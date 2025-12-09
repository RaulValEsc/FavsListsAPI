package com.raulvalesc.favslistsapi.modules.users.infrastructure.controller;

import com.raulvalesc.favslistsapi.modules.users.application.search.bycriteria.ByCriteriaUserSearcher;
import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.criteria.Criteria;
import com.raulvalesc.favslistsapi.shared.domain.criteria.SearchResponse;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;
import com.raulvalesc.favslistsapi.shared.infrastructure.persistance.criteria.CriteriaMapper;
import tools.jackson.databind.JsonNode;

@Injectable
public class UserSearchByCriteriaController {
    private final ByCriteriaUserSearcher searcher;

    public UserSearchByCriteriaController(ByCriteriaUserSearcher searcher) {
        this.searcher = searcher;
    }

    public SearchResponse<UserPrimitives> run(JsonNode criteriaJson) {
        Criteria criteria = CriteriaMapper.fromJson(criteriaJson);

        return this.searcher.search(criteria);
    }
}
