package com.quanlythuvien.controller;

import com.quanlythuvien.entity.Employee;
import com.quanlythuvien.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class EmployeeController {

//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }
//
//    @PostConstruct
//    public void test() {
//        List<Employee> list = findAll();
//        System.out.println("here employee controller");
//        System.out.println(list);
//    }
}
