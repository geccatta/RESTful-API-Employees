package com.geccatta.crud_demo.dao.User;

import com.geccatta.crud_demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImp implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> findUserQuery = entityManager.createQuery(
                "from User where username=:username and enabled=true", User.class
        );
        findUserQuery.setParameter("username", username);

        User user = null;
        try {
            user = findUserQuery.getSingleResult();
        } catch (Exception e) {
            user = null;
        }
        return user;
    }
}
