package com.ducatech.springboot.demo.MyCoolApp.dao;

import com.ducatech.springboot.demo.MyCoolApp.entity.Student;

import java.util.List;

public interface IStudentDao {

    void save(Student aStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student aStudent);

    void delete(Integer id);

    int deleteAll();

}
