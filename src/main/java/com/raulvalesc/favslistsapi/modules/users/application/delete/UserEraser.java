package com.raulvalesc.favslistsapi.modules.users.application.delete;

import com.raulvalesc.favslistsapi.modules.users.domain.User;
import com.raulvalesc.favslistsapi.modules.users.domain.UserId;
import com.raulvalesc.favslistsapi.modules.users.domain.UserRepository;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class UserEraser {
    private final UserRepository repository;

    public UserEraser(UserRepository repository) {
        this.repository = repository;
    }

    public void erase(String uuid) {
        UserId id = new UserId(uuid);

        User userToDelete = this.repository.searchById(id);

        if (userToDelete == null) {
            return;
        }

        this.repository.delete(User.delete(userToDelete.toPrimitives()));
    }
}
