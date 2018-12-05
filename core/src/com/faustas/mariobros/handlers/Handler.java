package com.faustas.mariobros.handlers;

import com.faustas.mariobros.events.Event;

public interface Handler<E extends Event> {
    void onEvent(E event);
}