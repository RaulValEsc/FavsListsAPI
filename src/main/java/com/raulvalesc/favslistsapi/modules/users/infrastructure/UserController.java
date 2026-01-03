package com.raulvalesc.favslistsapi.modules.users.infrastructure;

import com.raulvalesc.favslistsapi.modules.users.application.create.CreateUserCommand;
import com.raulvalesc.favslistsapi.modules.users.application.delete.DeleteUserCommand;
import com.raulvalesc.favslistsapi.modules.users.application.search.bycriteria.SearchUsersByCriteriaQuery;
import com.raulvalesc.favslistsapi.modules.users.application.search.bycriteria.SearchUsersByCriteriaResponse;
import com.raulvalesc.favslistsapi.modules.users.application.search.byid.FindUserByIdQuery;
import com.raulvalesc.favslistsapi.modules.users.application.search.byid.FindUserByIdResponse;
import com.raulvalesc.favslistsapi.modules.users.application.update.UpdateUserCommand;
import com.raulvalesc.favslistsapi.modules.users.infrastructure.dto.CreateUserRequest;
import com.raulvalesc.favslistsapi.modules.users.infrastructure.dto.SearchUsersResponse;
import com.raulvalesc.favslistsapi.modules.users.infrastructure.dto.UpdateUserRequest;
import com.raulvalesc.favslistsapi.modules.users.infrastructure.dto.UserResponse;
import com.raulvalesc.favslistsapi.shared.domain.bus.command.CommandBus;
import com.raulvalesc.favslistsapi.shared.domain.bus.query.QueryBus;
import com.raulvalesc.favslistsapi.shared.domain.criteria.Criteria;
import com.raulvalesc.favslistsapi.shared.infrastructure.persistance.criteria.CriteriaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.JsonNode;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public UserController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PutMapping
    public ResponseEntity<Void> create(@RequestBody CreateUserRequest request) {
        CreateUserCommand command = new CreateUserCommand(
                request.id(),
                request.name(),
                request.email(),
                request.password()
        );

        this.commandBus.dispatch(command);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        DeleteUserCommand command = new DeleteUserCommand(id);

        this.commandBus.dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable("id") String id) {
        FindUserByIdQuery query = new FindUserByIdQuery(id);

        FindUserByIdResponse response = this.queryBus.ask(query);

        return new ResponseEntity<>(UserResponse.fromPrimitives(response.getUser()), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") String id, @RequestBody UpdateUserRequest request) {
        UpdateUserCommand command = new UpdateUserCommand(
                id,
                request.name(),
                request.email(),
                request.password(),
                null,
                null
        );

        this.commandBus.dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<SearchUsersResponse> search(@RequestBody JsonNode body) {
        Criteria criteria = CriteriaMapper.fromJson(body);

        SearchUsersByCriteriaQuery query = new SearchUsersByCriteriaQuery(criteria);

        SearchUsersByCriteriaResponse response = this.queryBus.ask(query);

        return new ResponseEntity<>(SearchUsersResponse.fromSearchResponse(response.getSearchResponse()), HttpStatus.OK);
    }
}
