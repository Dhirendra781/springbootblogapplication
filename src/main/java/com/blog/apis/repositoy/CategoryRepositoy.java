package com.blog.apis.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entities.Category;

public interface CategoryRepositoy extends JpaRepository<Category, Integer>{

}
