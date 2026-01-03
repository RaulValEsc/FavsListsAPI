package com.raulvalesc.favslistsapi.modules.users.application.create;

import com.raulvalesc.favslistsapi.modules.users.domain.User;
import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.modules.users.domain.UserRepository;
import com.raulvalesc.favslistsapi.shared.domain.bus.event.EventBus;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class UserCreator {
    private final UserRepository repository;
    private final EventBus eventBus;

    public UserCreator(UserRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void create(UserPrimitives primitives) {
        User user = User.create(primitives);

        this.repository.create(user);

        this.eventBus.publish(user.pullDomainEvents());
    }
}
