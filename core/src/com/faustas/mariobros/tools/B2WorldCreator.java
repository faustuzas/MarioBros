package com.faustas.mariobros.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.faustas.mariobros.screens.PlayScreen;
import com.faustas.mariobros.sprites.Enemies.Enemy;
import com.faustas.mariobros.sprites.Enemies.Turtle;
import com.faustas.mariobros.sprites.TileObjects.Brick;
import com.faustas.mariobros.sprites.TileObjects.Coin;
import com.faustas.mariobros.sprites.Enemies.Goomba;
import com.faustas.mariobros.sprites.TileObjects.Gate;

public class B2WorldCreator {
    private Array<Goomba> goombas;
    private Array<Turtle> turtles;

    public B2WorldCreator(PlayScreen screen){
        World world = screen.getWorld();
        TiledMap map = screen.getMap();
        //create body and fixture variables
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //create ground bodies/fixtures
        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / Config.PPM, (rect.getY() + rect.getHeight() / 2) / Config.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / Config.PPM, rect.getHeight() / 2 / Config.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        //create pipe bodies/fixtures
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / Config.PPM, (rect.getY() + rect.getHeight() / 2) / Config.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / Config.PPM, rect.getHeight() / 2 / Config.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = Bits.OBJECT_BIT;
            body.createFixture(fdef);
        }

        //create brick bodies/fixtures
        for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            new Brick(screen, object);
        }

        //create coin bodies/fixtures
        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            new Coin(screen, object);
        }

        //create all goombas
        goombas = new Array<>();
        for(MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            goombas.add(new Goomba(screen, rect.getX() / Config.PPM, rect.getY() / Config.PPM));
        }
        turtles = new Array<>();
        for(MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            turtles.add(new Turtle(screen, rect.getX() / Config.PPM, rect.getY() / Config.PPM));
        }

        for(MapObject object : map.getLayers().get(8).getObjects().getByType(RectangleMapObject.class)){
            new Gate(screen, object);
        }
    }

    public Array<Enemy> getEnemies(){
        Array<Enemy> enemies = new Array<Enemy>();
        enemies.addAll(goombas);
        enemies.addAll(turtles);
        return enemies;
    }
}
