package com.raulvalesc.favslistsapi.modules.users.infrastructure.dto;

public record CreateUserRequest(
        String id,
        String name,
        String email,
        String password
) {}
