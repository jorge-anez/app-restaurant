package com.project.services;

import com.project.model.domain.security.Role;

/**
 * Created by JORGE-HP on 10/6/2017.
 */
public interface RoleService {
    Role findByName(String roleName);
}
