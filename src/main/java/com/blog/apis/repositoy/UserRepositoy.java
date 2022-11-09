package com.blog.apis.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entities.User;

public interface UserRepositoy extends JpaRepository<User, Integer>{

}
