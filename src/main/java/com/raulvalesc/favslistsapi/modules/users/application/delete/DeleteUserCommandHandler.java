package com.raulvalesc.favslistsapi.modules.users.application.delete;

import com.raulvalesc.favslistsapi.shared.domain.bus.command.CommandHandler;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class DeleteUserCommandHandler implements CommandHandler<DeleteUserCommand> {
    private final UserEraser eraser;

    public DeleteUserCommandHandler(UserEraser eraser) {
        this.eraser = eraser;
    }

    @Override
    public void handle(DeleteUserCommand command) {
        this.eraser.erase(command.getId());
    }
}
