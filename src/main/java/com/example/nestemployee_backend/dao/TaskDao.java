package com.example.nestemployee_backend.dao;

import com.example.nestemployee_backend.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<Task,Integer> {

    @Query(value = "SELECT e.`address`, e.`email`, e.`empcode`, e.`name`, e.`phno`,t.`task`,t.`status` FROM `employees` e JOIN task t ON e.empcode=t.empcode")
    List<Map<String,String>> viewall();
}
