package com.example.nestemployee_backend.dao;

import com.example.nestemployee_backend.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskDao extends CrudRepository<Task,Integer> {
}
