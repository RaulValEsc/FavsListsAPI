package com.raulvalesc.favslistsapi.modules.users.infrastructure.dto;

import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.criteria.SearchResponse;

import java.util.List;

public record SearchUsersResponse(
        int total,
        List<UserResponse> results
) {
    public static SearchUsersResponse fromSearchResponse(SearchResponse<UserPrimitives> searchResponse) {
        List<UserResponse> users = searchResponse.results.stream()
                .map(UserResponse::fromPrimitives)
                .toList();

        return new SearchUsersResponse(searchResponse.total, users);
    }
}
