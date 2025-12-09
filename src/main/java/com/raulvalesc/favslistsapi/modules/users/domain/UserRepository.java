package com.raulvalesc.favslistsapi.modules.users.domain;

import com.raulvalesc.favslistsapi.shared.domain.criteria.Criteria;
import com.raulvalesc.favslistsapi.shared.domain.criteria.SearchResponse;

public interface UserRepository {
    void create(User user);

    void delete(User user);

    SearchResponse<UserPrimitives> searchByCriteria(Criteria criteria);

    User searchById(UserId id);

    void update(User user);
}
