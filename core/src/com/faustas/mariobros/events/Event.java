package com.faustas.mariobros.events;

public interface Event {
    Class<? extends Event> getType();
}