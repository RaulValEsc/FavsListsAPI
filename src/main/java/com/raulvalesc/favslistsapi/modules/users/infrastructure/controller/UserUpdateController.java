package com.raulvalesc.favslistsapi.modules.users.infrastructure.controller;

import com.raulvalesc.favslistsapi.modules.users.application.update.UserUpdater;
import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class UserUpdateController {
    private final UserUpdater updater;

    public UserUpdateController(UserUpdater updater) {
        this.updater = updater;
    }

    public void run(String id, UserPrimitives primitives) {
        primitives.setId(id);

        this.updater.update(primitives);
    }
}
