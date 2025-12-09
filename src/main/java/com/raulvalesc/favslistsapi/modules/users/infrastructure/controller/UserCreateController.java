package com.raulvalesc.favslistsapi.modules.users.infrastructure.controller;

import com.raulvalesc.favslistsapi.modules.users.application.create.UserCreator;
import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class UserCreateController {
    private final UserCreator creator;

    public UserCreateController(UserCreator creator) {
        this.creator = creator;
    }

    public void run(UserPrimitives primitives) {
        this.creator.create(primitives);
    }
}
