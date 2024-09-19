package com.Studen.Startup.Controller;

import com.Studen.Startup.Request.StudentRequest;
import com.Studen.Startup.Student;
import com.Studen.Startup.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("add_student")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequest studentRequest) {
//        System.out.println(studentRequest.getName());
        return studentService.save(studentRequest);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllStudent() {
        return studentService.getAll();
    }

    @GetMapping("update")
    public Student update(Student student) {
        return studentService.update(student);
    }

    @GetMapping("by_id/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @GetMapping("by_name")
    public List<Student> getStudentByName(String name) {
        return studentService.getStudentByName(name);
    }

    @DeleteMapping("delete_student/{id}")
    public void deleteStudent(@PathVariable  int id) {
        studentService.deleteById(id);
    }
}
