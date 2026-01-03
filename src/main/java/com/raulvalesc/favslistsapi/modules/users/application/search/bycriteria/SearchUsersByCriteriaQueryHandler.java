package com.raulvalesc.favslistsapi.modules.users.application.search.bycriteria;

import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.bus.query.QueryHandler;
import com.raulvalesc.favslistsapi.shared.domain.criteria.SearchResponse;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class SearchUsersByCriteriaQueryHandler implements QueryHandler<SearchUsersByCriteriaQuery, SearchUsersByCriteriaResponse> {
    private final ByCriteriaUserSearcher searcher;

    public SearchUsersByCriteriaQueryHandler(ByCriteriaUserSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public SearchUsersByCriteriaResponse handle(SearchUsersByCriteriaQuery query) {
        SearchResponse<UserPrimitives> response = this.searcher.search(query.getCriteria());

        return new SearchUsersByCriteriaResponse(response);
    }
}
