package com.raulvalesc.favslistsapi.modules.users.infrastructure.controller;

import com.raulvalesc.favslistsapi.modules.users.application.delete.UserEraser;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class UserDeleteController {
    private final UserEraser eraser;

    public UserDeleteController(UserEraser eraser) {
        this.eraser = eraser;
    }

    public void run(String uuid) {
        this.eraser.erase(uuid);
    }
}
