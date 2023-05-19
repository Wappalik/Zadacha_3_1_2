package com.wappalik.Zadacha_3_1_2.service;


import com.wappalik.Zadacha_3_1_2.dao.UserDao;
import com.wappalik.Zadacha_3_1_2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional (readOnly = true)
    public List<User> getAllUsers() {
       return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        userDao.deleteEmployee(id);
    }
}
