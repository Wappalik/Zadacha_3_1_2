package com.wappalik.Zadacha_3_1_2.dao;


import com.wappalik.Zadacha_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List <User> getAllUsers () {
//        User user1 = new User("Malik", "IT",25,1000);
//        User user2 = new User("Erik", "HR",31,1500);
//        User user3 = new User("Olga", "Sales",28,1600);
//        User user4 = new User("Kostya", "Security",36,2000);
//        entityManager.persist(user1);
//        entityManager.persist(user2);
//        entityManager.persist(user3);
//        entityManager.persist(user4);
        TypedQuery<User> userQuery = entityManager.createQuery("from User", User.class);
        return userQuery.getResultList();

    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class,id);
        return user;
    }

    @Override
    public void deleteEmployee(int id) {
   TypedQuery <User>query = (TypedQuery<User>) entityManager.createQuery("delete from User where id=:userId");
    query.setParameter("userId",id).executeUpdate();
    }

}
