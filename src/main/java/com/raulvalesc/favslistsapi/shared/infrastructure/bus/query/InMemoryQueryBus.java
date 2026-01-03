package com.raulvalesc.favslistsapi.shared.infrastructure.bus.query;

import com.raulvalesc.favslistsapi.shared.domain.bus.query.Query;
import com.raulvalesc.favslistsapi.shared.domain.bus.query.QueryBus;
import com.raulvalesc.favslistsapi.shared.domain.bus.query.QueryHandler;
import com.raulvalesc.favslistsapi.shared.domain.bus.query.Response;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;
import org.springframework.context.ApplicationContext;

@Injectable
public class InMemoryQueryBus implements QueryBus {
    private final QueryHandlersInformation information;

    private final ApplicationContext context;

    public InMemoryQueryBus(QueryHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
    }

    @Override
    public <R extends Response> R ask(Query query) {
        Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());

        QueryHandler<Query, R> handler = context.getBean(queryHandlerClass);

        return handler.handle(query);
    }
}
