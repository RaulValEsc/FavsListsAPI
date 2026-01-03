package com.raulvalesc.favslistsapi.modules.users.application.delete;

import com.raulvalesc.favslistsapi.shared.domain.bus.command.Command;

public class DeleteUserCommand extends Command {
    private final String id;

    public DeleteUserCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
