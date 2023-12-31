package com.app.api.dao;

import com.app.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer> {
}
