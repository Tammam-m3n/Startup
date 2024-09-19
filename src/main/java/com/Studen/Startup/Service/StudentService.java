package com.Studen.Startup.Service;

import com.Studen.Startup.Course;
import com.Studen.Startup.Repository.CourseRepository;
import com.Studen.Startup.Repository.StudentRepository;
import com.Studen.Startup.Repository.WalletRepository;
import com.Studen.Startup.Request.StudentRequest;
import com.Studen.Startup.Response.CourseResponse;
import com.Studen.Startup.Response.StudentResponse;
import com.Studen.Startup.Response.WalletResponse;
import com.Studen.Startup.Student;
import com.Studen.Startup.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<?> save(StudentRequest studentRequest) {
//        System.out.println(studentRequest.getName());
//        Wallet wallet = walletRepository.findById(studentRequest.getWalletId()).orElse(null);
//        Course course = courseRepository.findById(studentRequest.getCourseId()).orElse(null);

        Wallet wallet = Wallet.builder()
                .bankAccountNumber(studentRequest.getWalletAccount())
                .build();
        walletRepository.save(wallet);
        Student student = Student.builder()
                .name(studentRequest.getName())
                .birthDate(studentRequest.getBirthDate())
                .mark(studentRequest.getMark())
                .wallet(wallet)
                .build();
                studentRepository.save(student);
//        System.out.println(student.getName());


//        student.setWallet(wallet);
//        studentRepository.save(student);


//        List<Course> courseList = courseRepository.findAll();
//        List<CourseResponse> courseResponseList = new ArrayList<>();
//        for (Course course1 : courseList) {
//            CourseResponse courseResponse = CourseResponse.builder()
//                    .id(course1.getId())
//                    .name(course1.getName())
//                    .description(course1.getDescription())
//                    .build();
//            courseResponseList.add(courseResponse);
//        }
//        ResponseEntity.status(HttpStatus.OK).body(courseResponseList);

        WalletResponse walletResponse = WalletResponse.builder()
                .id(wallet.getId())
                .bankAccountNumber(wallet.getBankAccountNumber())
                .build();

        StudentResponse studentResponse = StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .birthDate(student.getBirthDate())
                .mark(student.getMark())
                .walletAccount(walletResponse)
//                .walletId(wallet.getId())
//                .bankAccountNumber(wallet.getBankAccountNumber())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    public ResponseEntity<?> getAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student : students) {
            Wallet wallet = student.getWallet();
/*
            System.out.println(wallet.getBankAccountNumber());
*/
            WalletResponse walletResponse = WalletResponse.builder()
                    .id(wallet.getId())
                    .bankAccountNumber(wallet.getBankAccountNumber())
                    .build();

            StudentResponse studentResponse = StudentResponse.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .birthDate(student.getBirthDate())
                    .mark(student.getMark())
                    .walletAccount(walletResponse)
                    .build();
            studentResponses.add(studentResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResponses);
    }
    public List<Student> getStudentByName(String name) {
        return studentRepository.findStudentByName(name).orElse(null);
    }

    public ResponseEntity<?> findById(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Wallet wallet = student.getWallet();
        WalletResponse walletResponse = WalletResponse.builder()
                .id(wallet.getId())
                .bankAccountNumber(wallet.getBankAccountNumber())
                .build();
        StudentResponse studentResponse = StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .birthDate(student.getBirthDate())
                .mark(student.getMark())
                .walletAccount(walletResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }

    public void deleteById(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            studentRepository.deleteById(id);
            walletRepository.deleteById(id);
        }
    }

    public Student update(Student student) {
        Student stud = studentRepository.findById(student.getId()).orElse(null);

        if (stud != null) {
            stud.setName(student.getName());
            stud.setBirthDate(student.getBirthDate());
            stud.setMark(student.getMark());
            studentRepository.save(stud);
        }
        return stud;
    }
}
 