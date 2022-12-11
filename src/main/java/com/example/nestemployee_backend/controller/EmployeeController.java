package com.example.nestemployee_backend.controller;

import com.example.nestemployee_backend.dao.EmployeeDao;
import com.example.nestemployee_backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeDao dao;



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public Map<String,String> reg(@RequestBody Employee e)
    {
        dao.save(e);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> login(@RequestBody Employee e)
    {
        String username=String.valueOf(e.getUsername());
        String password=String.valueOf(e.getPassword());
        // return (List<Customers>) dao1.login(username,password);
        List<Employee> result=(List<Employee>) dao.login(username,password);
        HashMap<String,String> st=new HashMap<>();
        if (result.size()==0)
        {
            st.put("status","failed");
        }
        else
        {
            int id=result.get(0).getId();
            st.put("userid",String.valueOf(id));
            st.put("status","success");
        }
        return st;

    }
}
