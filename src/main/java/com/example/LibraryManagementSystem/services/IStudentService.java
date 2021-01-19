package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.models.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
    Student getStudentById(long id);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(long id);
    Page<Student> findPaginated(int pageNo, int pageSize);
}
