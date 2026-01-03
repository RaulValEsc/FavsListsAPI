package com.raulvalesc.favslistsapi.modules.users.application.search.byid;

import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.bus.query.Response;

public class FindUserByIdResponse extends Response {
    private final UserPrimitives user;

    public FindUserByIdResponse(UserPrimitives user) {
        this.user = user;
    }

    public UserPrimitives getUser() {
        return user;
    }
}
