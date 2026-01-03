package com.raulvalesc.favslistsapi.shared.infrastructure.bus.command;

import com.raulvalesc.favslistsapi.shared.domain.bus.command.Command;
import com.raulvalesc.favslistsapi.shared.domain.bus.command.CommandBus;
import com.raulvalesc.favslistsapi.shared.domain.bus.command.CommandHandler;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;
import org.springframework.context.ApplicationContext;

@Injectable
public class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;

    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public void dispatch(Command command) {
        Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

        CommandHandler handler = context.getBean(commandHandlerClass);

        handler.handle(command);
    }
}
