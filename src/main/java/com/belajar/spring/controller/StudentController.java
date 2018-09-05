package com.belajar.spring.controller;

import com.belajar.spring.dao.StudentDAO;
import com.belajar.spring.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping(value = "/students")
    public List<Student> students() {
        return studentDAO.find();
    }

    @PostMapping(value = "/students")
    public String save(@RequestBody Student student) {
        Student data = studentDAO.save(student);
        if (data.getId() == 0) {
            return "Gagal insert data";
        } else {
            return "Insert data berhasil";
        }
    }

}
