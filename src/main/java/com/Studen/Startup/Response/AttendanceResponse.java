package com.Studen.Startup.Response;

import com.Studen.Startup.Course;
import com.Studen.Startup.Student;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AttendanceResponse {

    private Integer id;
    private LocalDate date;

    private StudentResponse student;
    private CourseResponse course;
}
