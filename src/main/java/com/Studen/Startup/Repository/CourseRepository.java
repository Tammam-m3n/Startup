package com.Studen.Startup.Repository;

import com.Studen.Startup.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    public Optional<List<Course>> findCourseByName(String courseName);
}
