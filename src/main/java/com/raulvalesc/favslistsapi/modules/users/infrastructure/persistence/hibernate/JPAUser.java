package com.raulvalesc.favslistsapi.modules.users.infrastructure.persistence.hibernate;

import com.raulvalesc.favslistsapi.modules.users.domain.*;
import com.raulvalesc.favslistsapi.shared.infrastructure.persistance.hibernate.JPAEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "Users")
public class JPAUser extends JPAEntity {
    private String email;

    @Id
    private String id;

    private String name;

    private String password;

    protected JPAUser() {}

    private JPAUser(Instant createdAt, Instant deletedAt, String email, String id, Boolean isDeleted, String name, String password, Instant updatedAt) {
        super(createdAt, deletedAt, isDeleted, updatedAt);

        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public static JPAUser fromPrimitives(UserPrimitives primitives) {
        return new JPAUser(
                primitives.getCreatedAt(),
                primitives.getDeletedAt(),
                primitives.getEmail(),
                primitives.getId(),
                primitives.getIsDeleted(),
                primitives.getName(),
                primitives.getPassword(),
                primitives.getUpdatedAt()
        );
    }

    public UserPrimitives toPrimitives() {
        return new UserPrimitives(
                this.createdAt,
                this.deletedAt,
                this.email,
                this.id,
                this.isDeleted,
                this.name,
                this.password,
                this.updatedAt
        );
    }
}
