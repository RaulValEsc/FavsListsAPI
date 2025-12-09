package com.raulvalesc.favslistsapi.modules.users.application.search.byid;

import com.raulvalesc.favslistsapi.modules.users.domain.UserId;
import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.modules.users.domain.UserRepository;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class ByIdUserSearcher {
    private final UserRepository repository;

    public ByIdUserSearcher(UserRepository repository) {
        this.repository = repository;
    }

    public UserPrimitives findById(String uuid) {
        UserId id = new UserId(uuid);

        return this.repository.searchById(id).toPrimitives();
    }
}
