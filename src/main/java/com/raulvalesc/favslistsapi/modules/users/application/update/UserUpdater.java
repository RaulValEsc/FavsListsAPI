package com.raulvalesc.favslistsapi.modules.users.application.update;

import com.raulvalesc.favslistsapi.modules.users.domain.User;
import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.modules.users.domain.UserRepository;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class UserUpdater {
    private final UserRepository repository;

    public UserUpdater(UserRepository repository) {
        this.repository = repository;
    }

    public void update(UserPrimitives primitives) {
        User user = User.update(primitives);

        this.repository.update(user);
    }
}
