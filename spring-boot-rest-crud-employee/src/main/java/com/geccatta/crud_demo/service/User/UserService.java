package com.geccatta.crud_demo.service.User;

import com.geccatta.crud_demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
