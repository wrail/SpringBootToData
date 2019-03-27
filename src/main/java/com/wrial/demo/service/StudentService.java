package com.wrial.demo.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wrial.demo.Mapper.StudentMapper;
import com.wrial.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student getStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public Integer addStudent(String name, Integer age) {
        Student student = new Student();
        student.setId(null);
        student.setName(name);
        student.setAge(age);
        int flag = studentMapper.insert(student);
        return flag;
    }

    public List<Student> findUserByPage(Integer page, Integer row) {
        PageHelper.startPage(page, row);
        List<Student> students = studentMapper.selectAll();
        PageInfo pageInfo = new PageInfo(students);
        System.out.println(pageInfo.getSize());
        return students;
    }
}
