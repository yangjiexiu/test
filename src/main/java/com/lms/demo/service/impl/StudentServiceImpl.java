package com.lms.demo.service.impl;


import com.lms.demo.dao.StudentMapper;
import com.lms.demo.pojo.Student;
import com.lms.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper mapper;
    @Override
    public List<Student> getAll() {
        return mapper.getAll();
    }
}
