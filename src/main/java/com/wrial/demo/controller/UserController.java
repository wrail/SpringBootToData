package com.wrial.demo.controller;

import com.wrial.demo.domain.Student;
import com.wrial.demo.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("student")
public class UserController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/findStudent")
    public Student findUserById(@Param("id") Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/addStudnt")
    public Integer addStudent( @Param("name") String name, @Param("age") Integer age){
        return studentService.addStudent(name,age);
    }

    @GetMapping("/findStudentByPage")
    public List<Student> findStudentByPage(@Param("page") Integer page, @Param("row") Integer row){
        return studentService.findUserByPage(page,row);
    }
}
