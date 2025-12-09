package com.raulvalesc.favslistsapi.modules.users.domain;

import com.raulvalesc.favslistsapi.shared.domain.aggregateroot.*;

import java.time.Instant;

public class User extends AggregateRoot<UserPrimitives> {
    public final UserEmail email;

    public final UserId id;

    public final UserName name;

    public final UserPassword password;

    private User(AggregateRootCreatedAt createdAt, AggregateRootDeletedAt deletedAt, UserEmail email, UserId id, AggregateRootIsDeleted isDeleted, UserName name, UserPassword password, AggregateRootUpdatedAt updatedAt) {
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
                primitives.getCreatedAt() != null ? new AggregateRootCreatedAt(primitives.getCreatedAt()) : null,
                primitives.getDeletedAt() != null ? new AggregateRootDeletedAt(primitives.getDeletedAt()) : null,
                primitives.getEmail() != null ? new UserEmail(primitives.getEmail()) : null,
                primitives.getId() != null ? new UserId(primitives.getId()) : null,
                primitives.getIsDeleted() != null ? new AggregateRootIsDeleted(primitives.getIsDeleted()) : null,
                primitives.getName() != null ? new UserName(primitives.getName()) : null,
                primitives.getPassword() != null ? new UserPassword(primitives.getPassword()) : null,
                primitives.getUpdatedAt() != null ? new AggregateRootUpdatedAt(primitives.getUpdatedAt()) : null
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
