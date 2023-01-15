package fii.jt.lab8.repository;

import fii.jt.lab8.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Stateless
@Transactional
public class UserRepository {
    @PersistenceContext(unitName = "Lab8PersistenceUnit")
    EntityManager entityManager;

    public final void saveUser(User user) {
        entityManager.persist(user);
    }

    public final String login(String username, String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> playerRoot = criteriaQuery.from(User.class);

        Predicate predicateForUsername = criteriaBuilder.equal(playerRoot.get("username"), username);
        Predicate predicateForPassword = criteriaBuilder.equal(playerRoot.get("password"), password);
        Predicate finalPredicate = criteriaBuilder.and(predicateForUsername, predicateForPassword);

        criteriaQuery.where(finalPredicate);

        Query query = entityManager.createQuery(criteriaQuery);

        User user = (User) query.getSingleResult();

        return user.getRole();
    }
}
