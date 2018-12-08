package com.faustas.mariobros.handlers;

import com.faustas.mariobros.events.PlayerFireEvent;
import com.faustas.mariobros.sprites.Mario;

public class PlayerFireEventHandler extends PlayerEventsHandler<PlayerFireEvent> {
    public PlayerFireEventHandler(Mario player) {
        super(player);
    }

    @Override
    public void onEvent(PlayerFireEvent event) {
        player.fire();
    }
}
