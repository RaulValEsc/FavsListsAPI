package com.raulvalesc.favslistsapi.modules.users.application.update;

import com.raulvalesc.favslistsapi.shared.domain.bus.command.Command;

import java.time.Instant;

public class UpdateUserCommand extends Command {
    private final String id;
    private final String name;
    private final String email;
    private final String password;
    private final Instant createdAt;
    private final Boolean isDeleted;

    public UpdateUserCommand(String id, String name, String email, String password, Instant createdAt, Boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }
}
