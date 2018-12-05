package com.faustas.mariobros.handlers;

import com.faustas.mariobros.events.PlayerJumpEvent;
import com.faustas.mariobros.sprites.Mario;

public class PlayerJumpEventHandler extends PlayerEventsHandler<PlayerJumpEvent> {
    public PlayerJumpEventHandler(Mario player) {
        super(player);
    }

    @Override
    public void onEvent(PlayerJumpEvent event) {
        player.jump();
    }
}
