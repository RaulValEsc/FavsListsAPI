package com.raulvalesc.favslistsapi.api.routes;

import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.modules.users.infrastructure.controller.*;
import com.raulvalesc.favslistsapi.shared.domain.criteria.SearchResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.JsonNode;

@RestController
@RequestMapping("/users")
public class UserRoutes {
    private final UserCreateController createController;

    private final UserDeleteController deleteController;

    private final UserGetByIdController getByIdController;

    private final UserUpdateController updateController;

    private final UserSearchByCriteriaController searchController;

    public UserRoutes(UserCreateController createController, UserDeleteController deleteController, UserGetByIdController getByIdController, UserUpdateController updateController, UserSearchByCriteriaController searchController) {
        this.createController = createController;
        this.deleteController = deleteController;
        this.getByIdController = getByIdController;
        this.updateController = updateController;
        this.searchController = searchController;
    }

    @PutMapping
    public ResponseEntity<Void> create(@RequestBody UserPrimitives primitives) {
        this.createController.run(primitives);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String uuid) {
        this.deleteController.run(uuid);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPrimitives> getById(@PathVariable String uuid) {
        UserPrimitives primitives = this.getByIdController.run(uuid);

        return new ResponseEntity<>(primitives, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String uuid, @RequestBody UserPrimitives primitives) {
        this.updateController.run(uuid, primitives);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SearchResponse<UserPrimitives>> searchByCriteria(@RequestBody JsonNode body) {
        SearchResponse<UserPrimitives> response = this.searchController.run(body);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
