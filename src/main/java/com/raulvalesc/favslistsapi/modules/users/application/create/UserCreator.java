package com.raulvalesc.favslistsapi.modules.users.application.create;

import com.raulvalesc.favslistsapi.modules.users.domain.User;
import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.modules.users.domain.UserRepository;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class UserCreator {
    private final UserRepository repository;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
    }

    public void create(UserPrimitives primitives) {
        User user = User.create(primitives);

        this.repository.create(user);
    }
}
