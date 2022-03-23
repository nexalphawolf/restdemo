package com.app.restdemo.controller;

import java.util.ArrayList;
import java.util.List;

import com.app.restdemo.model.Student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//DEV BRANCH CHANGES

@RestController
public class HomeController {

ArrayList<Student> students;
    //@GetMapping("/")
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getGreeting(){

        Student s1 = new Student();
        s1.setId(10);
        s1.setName("Neel");

        Student s2 = new Student();
        s2.setId(20);
        s2.setName("Nehal");

        students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        return "Data is added in arrayLsit";
    }
    @GetMapping(value="/students",produces = { "application/json" })
    public List<Student> getStudents(){
        return this.students;
    }

    @DeleteMapping("/students/{id}")
    public boolean deleteStudent(@PathVariable("id") int id){
        boolean flag = false;
        for(Student s:this.students){
            if(s.getId() == id){
                this.students.remove(s);
                flag = true;
                break;
            }
        }
        return flag;
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student s){
        this.students.add(s);
    }


}
