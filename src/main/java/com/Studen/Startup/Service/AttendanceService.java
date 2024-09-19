package com.Studen.Startup.Service;

import com.Studen.Startup.Attendance;
import com.Studen.Startup.Repository.AttendanceRepository;
import com.Studen.Startup.Repository.CourseRepository;
import com.Studen.Startup.Repository.StudentRepository;
import com.Studen.Startup.Request.AttendanceRequest;
import com.Studen.Startup.Response.AttendanceResponse;
import com.Studen.Startup.Response.CourseResponse;
import com.Studen.Startup.Response.StudentResponse;
import com.Studen.Startup.Student;
import com.Studen.Startup.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<?> save(AttendanceRequest attendanceRequest) {
       Student student = studentRepository.findById(attendanceRequest.getStudentId()).orElse(null);
       Course course = courseRepository.findById(attendanceRequest.getCourseId()).orElse(null);
       Attendance attendance = Attendance.builder()
                .date(attendanceRequest.getDate())
                .student(student)
                .build();
        attendanceRepository.save(attendance);

        StudentResponse studentResponse = StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .birthDate(student.getBirthDate())
                .mark(student.getMark())
                .build();


        CourseResponse courseResponse = CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .startDate(course.getStartDate())
                .endDate(course.getEndDate())
                .price(course.getPrice())
                .build();


        AttendanceResponse attendanceResponse = AttendanceResponse.builder()
                .id(attendance.getId())
                .date(attendanceRequest.getDate())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(attendanceResponse);
    }

    public ResponseEntity<?> getAll() {

        List<Attendance> attendances = attendanceRepository.findAll();
        List<AttendanceResponse> attendanceResponses = new ArrayList<>();
        for (Attendance attendance : attendances) {
            AttendanceResponse attendanceResponse = AttendanceResponse.builder()
                    .id(attendance.getId())
                    .date(attendance.getDate())
                    .build();
            attendanceResponses.add(attendanceResponse);
        }

        return ResponseEntity.status(HttpStatus.OK).body(attendanceResponses);

    }

    public ResponseEntity<?> findById(int id) {
        Attendance attendance = attendanceRepository.findById(id).orElse(null);
        if (attendance == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        AttendanceResponse attendanceResponse = AttendanceResponse.builder()
                .id(attendance.getId())
                .date(attendance.getDate())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(attendanceResponse);
    }

    public void deleteById(int id) {
        Attendance attendance = attendanceRepository.findById(id).orElse(null);
        if (attendance != null) {
            attendanceRepository.deleteById(id);
        }
    }

    public Attendance update(Attendance attendance) {
        Attendance attend = attendanceRepository.findById(attendance.getId()).orElse(null);

        if (attend != null) {
            attend.setDate(attendance.getDate());
            attendanceRepository.save(attend);
        }
        return attend;
    }
}
