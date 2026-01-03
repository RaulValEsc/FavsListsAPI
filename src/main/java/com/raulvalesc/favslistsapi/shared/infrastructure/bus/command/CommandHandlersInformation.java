package com.raulvalesc.favslistsapi.shared.infrastructure.bus.command;

import com.raulvalesc.favslistsapi.shared.domain.bus.command.Command;
import com.raulvalesc.favslistsapi.shared.domain.bus.command.CommandHandler;
import com.raulvalesc.favslistsapi.shared.domain.bus.command.exception.CommandNotRegisteredException;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;
import org.reflections.Reflections;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

@Injectable
public final class CommandHandlersInformation {
    private HashMap<Class<? extends Command>, Class<? extends CommandHandler>> indexedCommandHandlers;

    public CommandHandlersInformation() {
        Reflections reflections = new Reflections("com.raulvalesc");

        Set<Class<? extends CommandHandler>> classes = reflections.getSubTypesOf(CommandHandler.class);

        indexedCommandHandlers = formatHandlers(classes);
    }

    public Class<? extends CommandHandler> search(Class<? extends Command> commandClass) {
        Class<? extends CommandHandler> commandHandlerClass = indexedCommandHandlers.get(commandClass);

        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredException(commandClass.getSimpleName());
        }

        return commandHandlerClass;
    }

    private HashMap<Class<? extends Command>, Class<? extends CommandHandler>> formatHandlers(Set<Class<? extends CommandHandler>> commandHandlers) {
        HashMap<Class<? extends Command>, Class<? extends CommandHandler>> handlers = new HashMap<>();

        for (Class<? extends CommandHandler> handler : commandHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];

            Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, handler);
        }

        return handlers;
    }
}
