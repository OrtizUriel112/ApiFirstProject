package com.app.api.service.Impl;

import com.app.api.dao.IUserDao;
import com.app.api.entity.User;
import com.app.api.repository.IUserRepository;
import com.app.api.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public List<User> findAll() {
        List<User> listUsers= iUserRepository.findAll();
        return listUsers;
    }

    @Override
    public User findById(int id) {
        User user = iUserRepository.findById(id);
        return user;
    }

    @Override
    public void save(User user) {
        user.setCreated_at(new Timestamp(System.currentTimeMillis()));
        user.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        user.setStatus(true);
        iUserRepository.save(user);
    }

    @Override
    public void update(int id, User userTemp){
        User user = iUserRepository.findById(id);

        if (userTemp.getEmail() != null){
            user.setEmail(userTemp.getEmail());
        }

        if (userTemp.getPassword() != null){
            user.setPassword(userTemp.getPassword());
        }

        user.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        iUserRepository.update(user);
    }

    @Override
    public void deleteById(int id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public void eraseById(int id){
        User user = iUserRepository.findById(id);
        if (user.getStatus()==false){
            System.out.println("User already status OFF");
        }else{
            user.setStatus(false);
            iUserRepository.eraseById(user);
        }

    }

    @Override
    public void reviveById(int id){
        User user = iUserRepository.findById(id);
        if (user.getStatus()==true){
            System.out.println("User already status ON");
        }else{
            user.setStatus(true);
            iUserRepository.reviveById(user);
        }
    }
}
