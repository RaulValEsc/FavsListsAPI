package com.raulvalesc.favslistsapi.modules.users.application.create;

import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.bus.command.CommandHandler;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {
    private final UserCreator creator;

    public CreateUserCommandHandler(UserCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateUserCommand command) {
        UserPrimitives primitives = new UserPrimitives(
                null,
                null,
                command.getEmail(),
                command.getId(),
                null,
                command.getName(),
                command.getPassword(),
                null
        );

        this.creator.create(primitives);
    }
}
