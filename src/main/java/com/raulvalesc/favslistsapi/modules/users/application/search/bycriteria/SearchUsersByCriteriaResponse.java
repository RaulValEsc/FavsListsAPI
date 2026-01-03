package com.raulvalesc.favslistsapi.modules.users.application.search.bycriteria;

import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.bus.query.Response;
import com.raulvalesc.favslistsapi.shared.domain.criteria.SearchResponse;

public class SearchUsersByCriteriaResponse extends Response {
    private final SearchResponse<UserPrimitives> searchResponse;

    public SearchUsersByCriteriaResponse(SearchResponse<UserPrimitives> searchResponse) {
        this.searchResponse = searchResponse;
    }

    public SearchResponse<UserPrimitives> getSearchResponse() {
        return searchResponse;
    }
}
