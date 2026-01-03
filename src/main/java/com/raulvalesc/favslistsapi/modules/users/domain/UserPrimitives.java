package com.raulvalesc.favslistsapi.modules.users.domain;

import com.raulvalesc.favslistsapi.shared.domain.entity.EntityPrimitives;

import java.time.Instant;

public class UserPrimitives extends EntityPrimitives {
    private String email;

    private String id;

    private String name;

    private String password;

    public UserPrimitives() {
        super();
    }

    public UserPrimitives(Instant createdAt, Instant deletedAt, String email, String id, Boolean isDeleted, String name, String password, Instant updatedAt) {
        super(createdAt, deletedAt, isDeleted, updatedAt);

        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
