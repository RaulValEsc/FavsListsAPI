package com.raulvalesc.favslistsapi.shared.domain.bus.query.exception;

import com.raulvalesc.favslistsapi.shared.domain.exceptions.InternalServerException;

public class QueryNotRegisteredException extends InternalServerException {
    public QueryNotRegisteredException(String queryName) {
        super("Query '" + queryName + "' is not registered.");
    }
}
