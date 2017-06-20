package com.project.services.impl;

import com.project.model.domain.security.Privilege;
import com.project.model.domain.security.Role;
import com.project.model.domain.security.User;
import com.project.services.RoleService;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by JORGE-HP on 10/6/2017.
 */
//@Service("userDetailsService")
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    //@Autowired
    //private UserRepository userRepository;

    @Autowired
    private UserService userService;

    //@Autowired
    //private MessageSource messages;

    @Autowired
    private RoleService roleService;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userService.findByEmail(email);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User("", "", true, true, true, true,
                    getAuthorities(Arrays.asList(roleService.findByName("ROLE_USER"))));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<String>();
        List<Privilege> collection = new ArrayList<Privilege>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
