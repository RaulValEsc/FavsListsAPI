package com.raulvalesc.favslistsapi.modules.users.application.search.byid;

import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.bus.query.QueryHandler;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;

@Injectable
public class FindUserByIdQueryHandler implements QueryHandler<FindUserByIdQuery, FindUserByIdResponse> {
    private final ByIdUserSearcher searcher;

    public FindUserByIdQueryHandler(ByIdUserSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public FindUserByIdResponse handle(FindUserByIdQuery query) {
        UserPrimitives user = this.searcher.findById(query.getId());

        return new FindUserByIdResponse(user);
    }
}
