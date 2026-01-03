package com.raulvalesc.favslistsapi.modules.users.application.delete;

import com.raulvalesc.favslistsapi.modules.users.domain.User;
import com.raulvalesc.favslistsapi.modules.users.domain.UserId;
import com.raulvalesc.favslistsapi.modules.users.domain.UserRepository;
import com.raulvalesc.favslistsapi.shared.domain.bus.event.EventBus;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class UserEraser {
    private final UserRepository repository;
    private final EventBus eventBus;

    public UserEraser(UserRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void erase(String uuid) {
        UserId id = new UserId(uuid);

        User userToDelete = this.repository.searchById(id);

        if (userToDelete == null) {
            return;
        }

        User deletedUser = User.delete(userToDelete.toPrimitives());

        this.repository.delete(deletedUser);

        this.eventBus.publish(deletedUser.pullDomainEvents());
    }
}
