package com.raulvalesc.favslistsapi.modules.users.infrastructure.dto;

public record UpdateUserRequest(
        String name,
        String email,
        String password
) {}
