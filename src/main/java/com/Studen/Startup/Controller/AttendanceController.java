package com.Studen.Startup.Controller;

import com.Studen.Startup.Attendance;
import com.Studen.Startup.Request.AttendanceRequest;
import com.Studen.Startup.Request.StudentRequest;
import com.Studen.Startup.Service.AttendanceService;
import com.Studen.Startup.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("add_attendance")
    public ResponseEntity<?> addAttendance(@RequestBody AttendanceRequest attendanceRequest) {
        return attendanceService.save(attendanceRequest);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllAttendance() {
        return attendanceService.getAll();
    }

    @GetMapping("by_id/{id}")
    public ResponseEntity<?> getAttendanceById(@PathVariable int id) {
        return  attendanceService.findById(id);
    }

    @GetMapping("update")
    public Attendance update(Attendance attendance) {
        return attendanceService.update(attendance);
    }

    @DeleteMapping("delete_attendance")
    public void deleteAttendance(int id) {
        attendanceService.deleteById(id);
    }
}
