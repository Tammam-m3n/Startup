package com.Studen.Startup;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "course_id")
    @SequenceGenerator(name = "course_id" ,sequenceName = "course_id" ,allocationSize = 1)
    private Integer id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;




}
