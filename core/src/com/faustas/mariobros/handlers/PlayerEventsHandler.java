package com.faustas.mariobros.handlers;

import com.faustas.mariobros.events.Event;
import com.faustas.mariobros.sprites.Mario;

abstract class PlayerEventsHandler<E extends Event> implements Handler<E> {
    Mario player;

    PlayerEventsHandler(Mario player) {
        this.player = player;
    }
}
