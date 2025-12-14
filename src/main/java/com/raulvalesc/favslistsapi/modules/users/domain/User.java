package com.raulvalesc.favslistsapi.modules.users.domain;

import com.raulvalesc.favslistsapi.shared.domain.entity.*;

import java.time.Instant;

public class User extends Entity<UserPrimitives> {
    public final UserEmail email;

    public final UserId id;

    public final UserName name;

    public final UserPassword password;

    private User(EntityCreatedAt createdAt, EntityDeletedAt deletedAt, UserEmail email, UserId id, EntityIsDeleted isDeleted, UserName name, UserPassword password, EntityUpdatedAt updatedAt) {
        super(createdAt, deletedAt, isDeleted, updatedAt);

        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public static User create(UserPrimitives primitives) {
        primitives.setCreatedAt(Instant.now());

        primitives.setIsDeleted(false);

        return User.fromPrimitives(primitives);
    }

    public static User delete(UserPrimitives primitives) {
        primitives.setDeletedAt(Instant.now());

        primitives.setIsDeleted(true);

        return User.fromPrimitives(primitives);
    }

    public static User fromPrimitives(UserPrimitives primitives) {
        return new User(
                primitives.getCreatedAt() != null ? new EntityCreatedAt(primitives.getCreatedAt()) : null,
                primitives.getDeletedAt() != null ? new EntityDeletedAt(primitives.getDeletedAt()) : null,
                primitives.getEmail() != null ? new UserEmail(primitives.getEmail()) : null,
                primitives.getId() != null ? new UserId(primitives.getId()) : null,
                primitives.getIsDeleted() != null ? new EntityIsDeleted(primitives.getIsDeleted()) : null,
                primitives.getName() != null ? new UserName(primitives.getName()) : null,
                primitives.getPassword() != null ? new UserPassword(primitives.getPassword()) : null,
                primitives.getUpdatedAt() != null ? new EntityUpdatedAt(primitives.getUpdatedAt()) : null
        );
    }

    public static User update(UserPrimitives primitives) {
        primitives.setUpdatedAt(Instant.now());

        return User.fromPrimitives(primitives);
    }

    public UserPrimitives toPrimitives() {
        return new UserPrimitives(
                this.createdAt.value,
                this.deletedAt.value,
                this.email.value,
                this.id.value,
                this.isDeleted.value,
                this.name.value,
                this.password.value,
                this.updatedAt.value
        );
    }
}
