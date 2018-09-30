package com.faustas.mariobros.Tools;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.faustas.mariobros.Sprites.Enemies.Enemy;
import com.faustas.mariobros.Sprites.Items.Item;
import com.faustas.mariobros.Sprites.Mario;
import com.faustas.mariobros.Sprites.Other.FireBall;
import com.faustas.mariobros.Sprites.TileObjects.InteractiveTileObject;

public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

        switch (cDef){
            case Bits.MARIO_BIT | Bits.GATE_BIT:
                if(fixA.getFilterData().categoryBits == Bits.GATE_BIT)
                    ((InteractiveTileObject) fixA.getUserData()).onHeadHit(null);
                else
                    ((InteractiveTileObject) fixB.getUserData()).onHeadHit(null);
                break;
            case Bits.MARIO_HEAD_BIT | Bits.BRICK_BIT:
            case Bits.MARIO_HEAD_BIT | Bits.COIN_BIT:
                if(fixA.getFilterData().categoryBits == Bits.MARIO_HEAD_BIT)
                    ((InteractiveTileObject) fixB.getUserData()).onHeadHit((Mario) fixA.getUserData());
                else
                    ((InteractiveTileObject) fixA.getUserData()).onHeadHit((Mario) fixB.getUserData());
                break;
            case Bits.ENEMY_HEAD_BIT | Bits.MARIO_BIT:
                if(fixA.getFilterData().categoryBits == Bits.ENEMY_HEAD_BIT)
                    ((Enemy)fixA.getUserData()).hitOnHead((Mario) fixB.getUserData());
                else
                    ((Enemy)fixB.getUserData()).hitOnHead((Mario) fixA.getUserData());
                break;
            case Bits.ENEMY_BIT | Bits.OBJECT_BIT:
            case Bits.ENEMY_BIT | Bits.GROUND_BIT:
                if(fixA.getFilterData().categoryBits == Bits.ENEMY_BIT)
                    ((Enemy)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Enemy)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case Bits.MARIO_BIT | Bits.ENEMY_BIT:
                if(fixA.getFilterData().categoryBits == Bits.MARIO_BIT)
                    ((Mario) fixA.getUserData()).hit((Enemy)fixB.getUserData());
                else
                    ((Mario) fixB.getUserData()).hit((Enemy)fixA.getUserData());
                break;
            case Bits.ENEMY_BIT:
                ((Enemy)fixA.getUserData()).hitByEnemy((Enemy)fixB.getUserData());
                ((Enemy)fixB.getUserData()).hitByEnemy((Enemy)fixA.getUserData());
                break;
            case Bits.ITEM_BIT | Bits.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == Bits.ITEM_BIT)
                    ((Item)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Item)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case Bits.ITEM_BIT | Bits.MARIO_BIT:
                if(fixA.getFilterData().categoryBits == Bits.ITEM_BIT)
                    ((Item)fixA.getUserData()).use((Mario) fixB.getUserData());
                else
                    ((Item)fixB.getUserData()).use((Mario) fixA.getUserData());
                break;
            case Bits.FIREBALL_BIT | Bits.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == Bits.FIREBALL_BIT)
                    ((FireBall)fixA.getUserData()).setToDestroy();
                else
                    ((FireBall)fixB.getUserData()).setToDestroy();
                break;
        }
    }

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
