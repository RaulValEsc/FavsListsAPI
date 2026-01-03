package com.raulvalesc.favslistsapi.modules.users.application.create;

import com.raulvalesc.favslistsapi.shared.domain.bus.command.Command;

public class CreateUserCommand extends Command {
    private final String id;
    private final String name;
    private final String email;
    private final String password;

    public CreateUserCommand(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
