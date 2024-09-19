package com.Studen.Startup.Request;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequest {

    private String name;
    private LocalDate birthDate ;
    private double mark;

    private String walletAccount;
//    private Integer courseId;
}
