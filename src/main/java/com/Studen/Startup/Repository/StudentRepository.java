package com.Studen.Startup.Repository;

import com.Studen.Startup.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Optional<List<Student>> findStudentByName(String studentName);
    public Student findStudentByWalletId(int id);

}
