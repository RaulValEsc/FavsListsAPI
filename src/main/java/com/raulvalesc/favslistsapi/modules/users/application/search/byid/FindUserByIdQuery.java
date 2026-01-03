package com.raulvalesc.favslistsapi.modules.users.application.search.byid;

import com.raulvalesc.favslistsapi.shared.domain.bus.query.Query;

public class FindUserByIdQuery extends Query {
    private final String id;

    public FindUserByIdQuery(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
