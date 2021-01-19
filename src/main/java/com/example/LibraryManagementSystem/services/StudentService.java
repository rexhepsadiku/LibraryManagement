package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.models.Student;
import com.example.LibraryManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudents() {
        List<Student> student = new ArrayList<Student>();
        studentRepository.findAll().forEach(student::add);
        return student;
    }
    public Student getStudentById(long id){return studentRepository.findById(id).get();}
    public void saveStudent(Student student){studentRepository.save(student);}
    public void updateStudent(Student student) {studentRepository.save(student);}
    public void deleteStudent(long id){studentRepository.deleteById(id);}
    @Override
    public Page<Student> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable);
    }
}
