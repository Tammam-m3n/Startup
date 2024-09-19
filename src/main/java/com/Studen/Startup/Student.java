package com.Studen.Startup;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Student")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Student {

    @Id
    @SequenceGenerator(name = "student_id" ,sequenceName = "student_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "student_id")
    private Integer id;

    @Column(name = "Name" ,length = 50)
    private String name;
    private LocalDate birthDate ;
    private double mark;

    @OneToOne
    private Wallet wallet;

    @OneToMany
    private List<Attendance> attendance;

    @ManyToMany()
    @JoinTable(name = "course_student",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courseList;

}
