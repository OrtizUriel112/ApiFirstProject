package com.app.api.repository;

import com.app.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {
    public List<User> findAll();
    public User findById(int id);
    public void save(User user);
    public User update(User user);
    public void deleteById(int id);
    public User eraseById(User user);
    public User reviveById(User user);
}
