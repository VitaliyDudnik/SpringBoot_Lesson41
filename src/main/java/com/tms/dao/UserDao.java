package com.tms.dao;

import com.tms.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    boolean existsUserByUsername(String username);

    boolean existsUserByPassword(String password);

    User getUserByPassword(String password);

}
