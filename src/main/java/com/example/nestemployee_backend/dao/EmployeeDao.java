package com.example.nestemployee_backend.dao;

import com.example.nestemployee_backend.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
