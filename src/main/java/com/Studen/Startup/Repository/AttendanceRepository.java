package com.Studen.Startup.Repository;

import com.Studen.Startup.Attendance;
import com.Studen.Startup.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

//    public Optional<List<Attendance>> findAll;

}
