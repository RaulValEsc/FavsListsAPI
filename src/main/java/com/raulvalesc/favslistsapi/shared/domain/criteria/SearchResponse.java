package com.raulvalesc.favslistsapi.shared.domain.criteria;

import java.util.List;

public class SearchResponse<T> {
    public int total;

    public List<T> results;

    public SearchResponse(int total, List<T> results) {
        this.total = total;

        this.results = results;
    }
}
