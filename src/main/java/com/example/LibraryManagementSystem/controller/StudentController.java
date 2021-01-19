package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.models.Student;
import com.example.LibraryManagementSystem.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @GetMapping("")
    public String getAllStudents(Model model) {
        return findPaginated(1,model);
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Student getOne(Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    public String addNewStudent(Student getstudent){
        studentService.saveStudent(getstudent);
        return "redirect:/students";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateStudent(Student student){
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteStudent(Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model) {
        int pageSize = 6;
        Page<Student> page = studentService.findPaginated(pageNo, pageSize);
        List<Student> listStudents = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("students", listStudents);
        return "students";
    }
}
