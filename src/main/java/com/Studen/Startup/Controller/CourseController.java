package com.Studen.Startup.Controller;

import com.Studen.Startup.Course;
import com.Studen.Startup.Request.CourseRequest;
import com.Studen.Startup.Request.StudentRequest;
import com.Studen.Startup.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("all")
    public ResponseEntity<?> getAllCourses() {
        return courseService.findAll();
    }

    @PostMapping("add_course")
    public ResponseEntity<?> addCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.save(courseRequest);
    }

    @GetMapping("find_by_id/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @GetMapping("find_by_name")
    public List<Course> getCourseByName(String name) {
        return courseService.getCourseByName(name);
    }

    @GetMapping("update")
    public Course update(Course course) {
        return courseService.update(course);
    }

    @DeleteMapping("delete_course/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteById(id);
    }
}
