package com.raulvalesc.favslistsapi.modules.users.infrastructure.persistence;

import com.raulvalesc.favslistsapi.modules.users.domain.User;
import com.raulvalesc.favslistsapi.modules.users.domain.UserId;
import com.raulvalesc.favslistsapi.modules.users.domain.UserPrimitives;
import com.raulvalesc.favslistsapi.modules.users.domain.UserRepository;
import com.raulvalesc.favslistsapi.modules.users.infrastructure.persistence.hibernate.JPAUser;
import com.raulvalesc.favslistsapi.shared.domain.criteria.Criteria;
import com.raulvalesc.favslistsapi.shared.domain.criteria.SearchResponse;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;
import com.raulvalesc.favslistsapi.shared.infrastructure.persistance.MyCriteriaRepository;
import jakarta.persistence.EntityManager;

@Injectable
public class JpaUserRepository extends MyCriteriaRepository<JPAUser, String> implements UserRepository {
    public JpaUserRepository(EntityManager entityManager) {
        super(JPAUser.class, entityManager);
    }

    @Override
    public void create(User user) {
        this._save(JPAUser.fromPrimitives(user.toPrimitives()));
    }

    @Override
    public void delete(User user) {
        this._remove(JPAUser.fromPrimitives(user.toPrimitives()));
    }

    @Override
    public SearchResponse<UserPrimitives> searchByCriteria(Criteria criteria) {
        SearchResponse<JPAUser> searchResponse = this._searchByCriteria(criteria);

        return new SearchResponse<UserPrimitives>(searchResponse.total, searchResponse.results.stream().map(JPAUser::toPrimitives).toList());
    }

    @Override
    public User searchById(UserId id) {
        return User.fromPrimitives(this._findById(id.value).toPrimitives());
    }

    @Override
    public void update(User user) {
        this._update(JPAUser.fromPrimitives(user.toPrimitives()));
    }
}
