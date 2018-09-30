package com.faustas.mariobros.Sprites.Items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.faustas.mariobros.MarioBros;
import com.faustas.mariobros.Screens.PlayScreen;
import com.faustas.mariobros.Sprites.Mario;
import com.faustas.mariobros.Tools.Config;

public abstract class Item extends Sprite {
    protected PlayScreen screen;
    protected World world;
    Vector2 velocity;
    private boolean toDestroy;
    private boolean destroyed;
    Body body;

    Item(PlayScreen screen, float x, float y){
        this.screen = screen;
        this.world = screen.getWorld();
        toDestroy = false;
        destroyed = false;

        setPosition(x, y);
        setBounds(getX(), getY(), 16 / Config.PPM, 16 / Config.PPM);
        defineItem();
    }

    public abstract void defineItem();
    public abstract void use(Mario mario);

    public void update(float dt){
        if(toDestroy && !destroyed){
            world.destroyBody(body);
            destroyed = true;
        }
    }

    public void draw(Batch batch){
        if(!destroyed)
            super.draw(batch);
    }

    void destroy(){
        toDestroy = true;
    }

    public void reverseVelocity(boolean x, boolean y){
        if(x)
            velocity.x = -velocity.x;
        if(y)
            velocity.y = -velocity.y;
    }
}
