package com.Studen.Startup.Service;

import com.Studen.Startup.Course;
import com.Studen.Startup.Repository.CourseRepository;
import com.Studen.Startup.Request.CourseRequest;
import com.Studen.Startup.Response.CourseResponse;
import com.Studen.Startup.Response.WalletResponse;
import com.Studen.Startup.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<?> save(CourseRequest courseRequest) {
        Course course = Course.builder()
                .name(courseRequest.getName())
                .description(courseRequest.getDescription())
                .startDate(courseRequest.getStartDate())
                .endDate(courseRequest.getEndDate())
                .price(courseRequest.getPrice())
                .build();
                courseRepository.save(course);

        CourseResponse courseResponse = CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .startDate(course.getStartDate())
                .endDate(course.getEndDate())
                .price(course.getPrice())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(courseResponse);
    }

    public ResponseEntity<?> findAll() {
//        List<Course> courses = courseRepository.findAll();
//        List<CourseResponse> courseResponses = new ArrayList<>();
//        CourseResponse courseResponse = null;
//        for (Course course : courses) {
//            courseResponse = CourseResponse.builder()
//                    .id(course.getId())
//                    .name(course.getName())
//                    .description(course.getDescription())
//                    .startDate(course.getStartDate())
//                    .endDate(course.getEndDate())
//                    .price(course.getPrice())
//                    .build();
//            courseResponses.add(courseResponse);
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(courseResponse);
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse>  courseResponses = new ArrayList<>();
        for (Course course : courses) {
            CourseResponse courseResponse = CourseResponse.builder()
                    .id(course.getId())
                    .name(course.getName())
                    .description(course.getDescription())
                    .startDate(course.getStartDate())
                    .endDate(course.getEndDate())
                    .price(course.getPrice())
                    .build();
            courseResponses.add(courseResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(courseResponses);

    }

    public ResponseEntity<?> findById(int id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course Not Found");
        }
        CourseResponse courseResponse = CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .startDate(course.getStartDate())
                .endDate(course.getEndDate())
                .price(course.getPrice())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(courseResponse);
    }

    public List<Course> getCourseByName(String name) {
        return courseRepository.findCourseByName(name).orElse(null);
    }

    public void deleteById(int id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            courseRepository.deleteById(id);
        }
    }

    public Course update(Course course) {
        Course cours = courseRepository.findById(course.getId()).orElse(null);

        if (cours != null) {
            cours.setName(cours.getName());
            cours.setDescription(cours.getDescription());
            cours.setStartDate(cours.getStartDate());
            cours.setEndDate(cours.getEndDate());
            cours.setPrice(cours.getPrice());
            courseRepository.save(cours);
        }
        return cours;
    }
}
