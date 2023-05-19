package com.wappalik.Zadacha_3_1_2.dao;



import com.wappalik.Zadacha_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers ();
    void saveUser (User user);
    User getUser (int id);
    public void deleteEmployee (int id);
}
