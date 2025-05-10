package com.geccatta.crud_demo.dao.User;

import com.geccatta.crud_demo.entity.User;

public interface UserDAO {
    User findByUsername(String username);
}
