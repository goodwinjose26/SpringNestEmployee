package com.example.nestemployee_backend.controller;

import com.example.nestemployee_backend.dao.TaskDao;
import com.example.nestemployee_backend.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    @Autowired
    private TaskDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addtask",consumes = "application/json",produces = "application/json")
    public Map<String,String> addTask(@RequestBody Task t)
    {
        System.out.println(t.getEmpcode());
        System.out.println(t.getTask().toString());

        System.out.println(t.getStatus().toString());
        HashMap<String,String> map=new HashMap<>();
        dao.save(t);
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewall")
    public List<Map<String,String>> viewall()
    {
        return (List<Map<String, String>>) dao.viewall();
    }


}
