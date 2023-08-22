package com.app.api.repository.Impl;

import com.app.api.entity.User;
import com.app.api.repository.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> theQuery = currentSession.createQuery("from User", User.class);

        List<User> users = theQuery.getResultList();

        currentSession.close();
        return users;
    }

    @Override
    public User findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        User user = currentSession.get(User.class, id);

        currentSession.close();
        return user;
    }

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.save(user);
        currentSession.close();
    }

    @Transactional
    public User update(User user)  { 
        return entityManager.merge(user);
    }


    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> theQuery = currentSession.createQuery("delete from User where id=:idUser");

        theQuery.setParameter("idUser", id);
        theQuery.executeUpdate();

        currentSession.close();
    }
    @Transactional
    public User eraseById(User user){
        return entityManager.merge(user);
    }

    @Transactional
    public User reviveById(User user){
        return entityManager.merge(user);
    }
}
