package com.raulvalesc.favslistsapi.modules.users.application.search.bycriteria;

import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.modules.users.domain.UserRepository;
import com.raulvalesc.favslistsapi.shared.domain.criteria.Criteria;
import com.raulvalesc.favslistsapi.shared.domain.criteria.SearchResponse;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class ByCriteriaUserSearcher {
    private final UserRepository repository;

    public ByCriteriaUserSearcher(UserRepository repository) {
        this.repository = repository;
    }

    public SearchResponse<UserPrimitives> search(Criteria criteria) {
        return this.repository.searchByCriteria(criteria);
    }
}
