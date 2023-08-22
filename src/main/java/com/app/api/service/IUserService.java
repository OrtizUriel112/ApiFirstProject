package com.app.api.service;

import com.app.api.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    public List<User> findAll();
    public User findById(int id);
    public void save(User user);
    public void update(int id, User user);
    public void deleteById(int id);
    public void eraseById(int id);
    public void reviveById(int id);
}
