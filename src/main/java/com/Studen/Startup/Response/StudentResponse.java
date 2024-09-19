package com.Studen.Startup.Response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StudentResponse {

    private int id;
    private String name;
    private LocalDate birthDate ;
    private double mark;

    private WalletResponse walletAccount;
//    private Integer walletId;
//    private String bankAccountNumber;

//    private List<CourseResponse> courses;
}
