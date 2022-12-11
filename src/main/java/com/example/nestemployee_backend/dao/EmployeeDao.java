package com.example.nestemployee_backend.dao;

import com.example.nestemployee_backend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `empcode`, `name`, `password`, `phno`, `username` FROM `employees` WHERE `username`=:username AND`password`=:password ",nativeQuery = true)
    List<Employee> login(@Param("username") String username, @Param("password") String password);

}
