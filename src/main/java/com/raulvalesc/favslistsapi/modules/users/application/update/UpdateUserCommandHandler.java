package com.raulvalesc.favslistsapi.modules.users.application.update;

import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.bus.command.CommandHandler;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class UpdateUserCommandHandler implements CommandHandler<UpdateUserCommand> {
    private final UserUpdater updater;

    public UpdateUserCommandHandler(UserUpdater updater) {
        this.updater = updater;
    }

    @Override
    public void handle(UpdateUserCommand command) {
        UserPrimitives primitives = new UserPrimitives(
                command.getCreatedAt(),
                null,
                command.getEmail(),
                command.getId(),
                command.getIsDeleted(),
                command.getName(),
                command.getPassword(),
                null
        );

        this.updater.update(primitives);
    }
}
