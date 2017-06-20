package com.project.services;

import com.project.model.domain.security.User;

/**
 * Created by JORGE-HP on 10/6/2017.
 */
public interface UserService {
    User findByEmail(String email);
}
