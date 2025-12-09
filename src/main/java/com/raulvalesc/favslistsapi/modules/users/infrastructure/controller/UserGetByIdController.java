package com.raulvalesc.favslistsapi.modules.users.infrastructure.controller;

import com.raulvalesc.favslistsapi.modules.users.application.search.byid.ByIdUserSearcher;
import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class UserGetByIdController {
    private final ByIdUserSearcher searcher;

    public UserGetByIdController(ByIdUserSearcher searcher) {
        this.searcher = searcher;
    }

    public UserPrimitives run(String uuid) {
        return this.searcher.findById(uuid);
    }
}
