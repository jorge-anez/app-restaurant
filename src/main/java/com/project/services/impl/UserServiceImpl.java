package com.project.services.impl;

import com.project.dao.GenericDAOImpl;
import com.project.model.domain.security.User;
import com.project.model.transer.UserDTO;
import com.project.services.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORGE-HP on 20/3/2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SessionFactory sessionFactory;
    private GenericDAOImpl<User, Long> userDAO;
    @PostConstruct
    public void init() {
        userDAO = new GenericDAOImpl<User, Long>(sessionFactory, User.class);
    }

    @Transactional
    public void create(UserDTO personDTO) {

    }

    public void update(UserDTO personDTO) {

    }

    @Transactional
    public User findByEmail(String email) {

        return null;
    }

    @Transactional
    public UserDTO findByUsername(String username) {

       return null;
    }

    @Transactional
    public List<UserDTO> listAll() {

        return null;
    }

    @Transactional
    public void resetPassword(Integer userId) {

    }

    @Transactional
    public void changePassword(Integer userID, String newPassword) {

    }
}
