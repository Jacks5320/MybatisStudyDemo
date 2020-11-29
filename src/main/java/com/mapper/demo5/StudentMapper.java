package com.mapper.demo5;

import com.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> findStudentList();

    List<Student> findStudentList2();
}
