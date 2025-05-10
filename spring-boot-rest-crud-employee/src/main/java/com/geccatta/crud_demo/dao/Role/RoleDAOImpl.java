package com.geccatta.crud_demo.dao.Role;

import com.geccatta.crud_demo.entity.Role;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {
    private EntityManager entityManager;

    @Autowired
    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role findRoleByName(String theRoleName) {
        return entityManager.find(Role.class, theRoleName);
    }
}
