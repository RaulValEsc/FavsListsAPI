package com.raulvalesc.favslistsapi.modules.users.infrastructure.dto;

import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;

import java.time.Instant;

public record UserResponse(
        String id,
        String name,
        String email,
        Instant createdAt,
        Instant updatedAt
) {
    public static UserResponse fromPrimitives(UserPrimitives primitives) {
        return new UserResponse(
                primitives.getId(),
                primitives.getName(),
                primitives.getEmail(),
                primitives.getCreatedAt(),
                primitives.getUpdatedAt()
        );
    }
}
