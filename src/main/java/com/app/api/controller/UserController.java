package com.app.api.controller;

import com.app.api.entity.User;
import com.app.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/users")
    public List<User> findAll(){
        return iUserService.findAll();
    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        User user = iUserService.findById(id);
        if (user == null){
            throw new RuntimeException("User id not found -"+id);
        }
        return user;
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user){

        iUserService.save(user);

        return user;
    }
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User userNew){

        iUserService.update(id, userNew);

        return userNew;
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        User user = iUserService.findById(id);
        if (user == null){
            throw new RuntimeException("User id not found -"+id);
        }

        iUserService.deleteById(id);
        return "Deleted user id - "+id;
    }
    @PutMapping("/users-erase/{id}")
    public String eraseUser(@PathVariable int id){

        iUserService.eraseById(id);

        return "Erase user id - "+id;
    }
    @PutMapping("/users-revive/{id}")
    public String reviveUser(@PathVariable int id){

        iUserService.reviveById(id);

        return "Revive user id - "+id;
    }

}
