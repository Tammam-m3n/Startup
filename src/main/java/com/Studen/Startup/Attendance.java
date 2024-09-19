package com.Studen.Startup;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "attendance_id")
    @SequenceGenerator(name = "attendance_id" ,sequenceName = "attendance_id" ,allocationSize = 1)
    private Integer id;
    private LocalDate date;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

}
