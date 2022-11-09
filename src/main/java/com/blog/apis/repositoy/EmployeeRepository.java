package com.blog.apis.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
