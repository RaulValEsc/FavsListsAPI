package com.raulvalesc.favslistsapi.modules.users.domain;

import com.raulvalesc.favslistsapi.modules.users.domain.events.UserCreatedEvent;
import com.raulvalesc.favslistsapi.modules.users.domain.events.UserDeletedEvent;
import com.raulvalesc.favslistsapi.modules.users.domain.events.UserUpdatedEvent;
import com.raulvalesc.favslistsapi.shared.domain.aggregate.AggregateRoot;
import com.raulvalesc.favslistsapi.shared.domain.entity.*;

import java.time.Instant;

public class User extends AggregateRoot<UserPrimitives> {
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

        User user = User.fromPrimitives(primitives);

        user.record(new UserCreatedEvent(
                user.id.value,
                user.name.value,
                user.email.value
        ));

        return user;
    }

    public static User delete(UserPrimitives primitives) {
        primitives.setDeletedAt(Instant.now());
        primitives.setIsDeleted(true);

        User user = User.fromPrimitives(primitives);

        user.record(new UserDeletedEvent(user.id.value));

        return user;
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

        User user = User.fromPrimitives(primitives);

        user.record(new UserUpdatedEvent(
                user.id.value,
                user.name.value,
                user.email.value
        ));

        return user;
    }

    public UserPrimitives toPrimitives() {
        return new UserPrimitives(
                this.createdAt != null ? this.createdAt.value : null,
                this.deletedAt != null ? this.deletedAt.value : null,
                this.email != null ? this.email.value : null,
                this.id != null ? this.id.value : null,
                this.isDeleted != null ? this.isDeleted.value : null,
                this.name != null ? this.name.value : null,
                this.password != null ? this.password.value : null,
                this.updatedAt != null ? this.updatedAt.value : null
        );
    }
}
