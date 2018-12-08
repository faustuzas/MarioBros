package com.faustas.mariobros.tools;

import com.faustas.mariobros.events.Event;
import com.faustas.mariobros.handlers.Handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcher {
    private static EventDispatcher INSTANCE = new EventDispatcher();
    public static EventDispatcher getInstance() {
        return INSTANCE;
    }

    private Map<Class<? extends Event>, List<Handler<? extends Event>>> handlersByType;

    private EventDispatcher() {
        this.handlersByType = new HashMap<>();
    }

    public <E extends Event> void registerHandler(Class<E> eventType, Handler<E> handler) {
        List<Handler<? extends Event>> handlerList = handlersByType.get(eventType);
        if (handlerList == null) {
            handlerList = new ArrayList<>();
        }

        handlerList.add(handler);
        handlersByType.put(eventType, handlerList);
    }

    @SuppressWarnings("unchecked")
    public <E extends Event> void dispatch(E event) {
        List<Handler<? extends Event>> handlers = handlersByType.get(event.getClass());
        if (handlers != null) {
            handlers.forEach(handler -> {
                Handler<E> castedHandler = (Handler<E>) handler;
                castedHandler.onEvent(event);
            });
        }
    }

    public void unregisterAll() {
        handlersByType.clear();
    }
}