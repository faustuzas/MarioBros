package com.faustas.mariobros.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faustas.mariobros.MarioBros;
import com.faustas.mariobros.events.PlayerFireEvent;
import com.faustas.mariobros.events.PlayerGoLeftEvent;
import com.faustas.mariobros.events.PlayerGoRightEvent;
import com.faustas.mariobros.events.PlayerJumpEvent;
import com.faustas.mariobros.handlers.PlayerFireEventHandler;
import com.faustas.mariobros.handlers.PlayerGoLeftEventHandler;
import com.faustas.mariobros.handlers.PlayerGoRightEventHandler;
import com.faustas.mariobros.handlers.PlayerJumpEventHandler;
import com.faustas.mariobros.scenes.Hud;
import com.faustas.mariobros.sprites.Enemies.Enemy;
import com.faustas.mariobros.sprites.Items.Item;
import com.faustas.mariobros.sprites.Items.ItemDef;
import com.faustas.mariobros.sprites.Items.Mushroom;
import com.faustas.mariobros.sprites.Mario;
import com.faustas.mariobros.tools.B2WorldCreator;
import com.faustas.mariobros.tools.Config;
import com.faustas.mariobros.tools.EventDispatcher;
import com.faustas.mariobros.tools.WorldContactListener;

import java.util.concurrent.LinkedBlockingQueue;

public class PlayScreen implements Screen {
    public boolean toNextLevel = false;

    //Reference to our Game, used to set Screens
    private MarioBros game;
    private TextureAtlas atlas;
    public static boolean alreadyDestroyed = false;
    private Hud hud;

    //basic playscreen variables
    private OrthographicCamera gamecam;
    private Viewport gamePort;

    //Tiled map variables
    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    //Box2d variables
    private World world;
    private Box2DDebugRenderer b2dr;
    private B2WorldCreator creator;

    //sprites
    private Mario player;

    private Music music;

    private Array<Item> items;
    private LinkedBlockingQueue<ItemDef> itemsToSpawn;

    private EventDispatcher eventDispatcher = EventDispatcher.getInstance();

    public PlayScreen(MarioBros game, Hud hud, String mapName){
        this.game = game;
        this.hud = hud;

        atlas = new TextureAtlas("Mario_and_Enemies.pack");

        //create cam used to follow mario through cam world
        gamecam = new OrthographicCamera();

        //create a FitViewport to maintain virtual aspect ratio despite screen size
        gamePort = new FitViewport(Config.V_WIDTH / Config.PPM, Config.V_HEIGHT / Config.PPM, gamecam);

        //Load our map and setup our map renderer
        maploader = new TmxMapLoader();
        map = maploader.load(mapName);
        renderer = new OrthogonalTiledMapRenderer(map, 1  / Config.PPM);

        //initially set our gamcam to be centered correctly at the start of of map
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        //create our Box2D world, setting no gravity in X, -10 gravity in Y, and allow bodies to sleep
        world = new World(new Vector2(0, -10), true);
        //allows for debug lines of our box2d world.
        b2dr = new Box2DDebugRenderer();

        creator = new B2WorldCreator(this);

        //create mario in our game world
        player = new Mario(this);

        eventDispatcher.registerHandler(PlayerGoLeftEvent.class, new PlayerGoLeftEventHandler(player));
        eventDispatcher.registerHandler(PlayerGoRightEvent.class, new PlayerGoRightEventHandler(player));
        eventDispatcher.registerHandler(PlayerJumpEvent.class, new PlayerJumpEventHandler(player));
        eventDispatcher.registerHandler(PlayerFireEvent.class, new PlayerFireEventHandler(player));

        world.setContactListener(new WorldContactListener());

        music = MarioBros.manager.get("audio/music/mario_music.ogg", Music.class);
        music.setLooping(true);
        music.setVolume(0.3f);
        music.play();

        items = new Array<>();
        itemsToSpawn = new LinkedBlockingQueue<>();
    }

    public void spawnItem(ItemDef idef){
        itemsToSpawn.add(idef);
    }

    private void handleSpawningItems(){
        if(!itemsToSpawn.isEmpty()){
            ItemDef idef = itemsToSpawn.poll();
            if(idef.type == Mushroom.class){
                items.add(new Mushroom(this, idef.position.x, idef.position.y));
            }
        }
    }

    public TextureAtlas getAtlas(){
        return atlas;
    }

    void handleInput(float dt){
        if(player.currentState != Mario.State.DEAD) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP))
                eventDispatcher.dispatch(new PlayerJumpEvent());
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2)
                eventDispatcher.dispatch(new PlayerGoRightEvent());
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x >= -2)
                eventDispatcher.dispatch(new PlayerGoLeftEvent());
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyJustPressed(Input.Keys.F))  {
                eventDispatcher.dispatch(new PlayerFireEvent());
            }
        }

    }

    void update(float dt){
        //handle user input first
        handleInput(dt);
        handleSpawningItems();

        //takes 1 step in the physics simulation(60 times per second)
        world.step(1 / 60f, 6, 2);

        player.update(dt);
        for(Enemy enemy : creator.getEnemies()) {
            enemy.update(dt);
            if(enemy.getX() < player.getX() + 224 / Config.PPM) {
                enemy.b2body.setActive(true);
            }
        }

        for(Item item : items)
            item.update(dt);

        hud.update(dt);

        //attach our gamecam to our players.x coordinate
        if(player.currentState != Mario.State.DEAD) {
            gamecam.position.x = player.b2body.getPosition().x;
        }

        //update our gamecam with correct coordinates after changes
        gamecam.update();
        //tell our renderer to draw only what our camera can see in our game world.
        renderer.setView(gamecam);

    }

    @Override
    public void render(float delta) {
        //separate our update logic from render
        update(delta);

        //Clear the game screen with Black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //render our game map
        renderer.render();

        //renderer our Box2DDebugLines
        b2dr.render(world, gamecam.combined);

        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        player.draw(game.batch);
        for (Enemy enemy : creator.getEnemies())
            enemy.draw(game.batch);
        for (Item item : items)
            item.draw(game.batch);
        game.batch.end();

        //Set our batch to now draw what the Hud camera sees.
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        if (toNextLevel) {
            game.playNextLevel();
            dispose();
        }

        if(gameOver()){
            game.setScreen(new GameOverScreen(game));
            dispose();
        }
    }

    private boolean gameOver(){
        return player.currentState == Mario.State.DEAD && player.getStateTimer() > 3;
    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        eventDispatcher.unregisterAll();
    }

    public Hud getHud(){ return hud; }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
    }

    public TiledMap getMap(){
        return map;
    }
    public World getWorld(){
        return world;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void show() { }
}
