package com.geccatta.crud_demo.dao.Role;
import com.geccatta.crud_demo.entity.Role;

public interface RoleDAO {
    Role findRoleByName(String theRoleName);
}
