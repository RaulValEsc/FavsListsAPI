package com.raulvalesc.favslistsapi.shared.infrastructure.bus.event;

import com.raulvalesc.favslistsapi.shared.domain.bus.event.DomainEvent;
import com.raulvalesc.favslistsapi.shared.domain.bus.event.EventHandler;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;
import org.reflections.Reflections;

import java.lang.reflect.ParameterizedType;
import java.util.*;

@Injectable
public final class EventHandlersInformation {
    private final HashMap<Class<? extends DomainEvent>, List<Class<? extends EventHandler>>> indexedEventHandlers;

    public EventHandlersInformation() {
        Reflections reflections = new Reflections("com.raulvalesc");

        Set<Class<? extends EventHandler>> classes = reflections.getSubTypesOf(EventHandler.class);

        indexedEventHandlers = formatHandlers(classes);
    }

    public List<Class<? extends EventHandler>> search(Class<? extends DomainEvent> eventClass) {
        List<Class<? extends EventHandler>> handlers = indexedEventHandlers.get(eventClass);

        return handlers != null ? handlers : Collections.emptyList();
    }

    private HashMap<Class<? extends DomainEvent>, List<Class<? extends EventHandler>>> formatHandlers(
            Set<Class<? extends EventHandler>> eventHandlers
    ) {
        HashMap<Class<? extends DomainEvent>, List<Class<? extends EventHandler>>> handlers = new HashMap<>();

        for (Class<? extends EventHandler> handler : eventHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];

            Class<? extends DomainEvent> eventClass = (Class<? extends DomainEvent>) paramType.getActualTypeArguments()[0];

            handlers.computeIfAbsent(eventClass, k -> new ArrayList<>()).add(handler);
        }

        return handlers;
    }
}
