package com.faustas.mariobros.handlers;

import com.badlogic.gdx.math.Vector2;
import com.faustas.mariobros.events.PlayerGoLeftEvent;
import com.faustas.mariobros.sprites.Mario;

public class PlayerGoLeftEventHandler extends PlayerEventsHandler<PlayerGoLeftEvent> {
    public PlayerGoLeftEventHandler(Mario player) {
        super(player);
    }

    @Override
    public void onEvent(PlayerGoLeftEvent event) {
        player.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), player.b2body.getWorldCenter(), true);
    }
}
