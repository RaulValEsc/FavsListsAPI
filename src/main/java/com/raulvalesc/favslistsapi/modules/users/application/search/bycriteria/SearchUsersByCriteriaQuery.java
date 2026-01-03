package com.raulvalesc.favslistsapi.modules.users.application.search.bycriteria;

import com.raulvalesc.favslistsapi.shared.domain.bus.query.Query;
import com.raulvalesc.favslistsapi.shared.domain.criteria.Criteria;

public class SearchUsersByCriteriaQuery extends Query {
    private final Criteria criteria;

    public SearchUsersByCriteriaQuery(Criteria criteria) {
        this.criteria = criteria;
    }

    public Criteria getCriteria() {
        return criteria;
    }
}
