package com.Studen.Startup.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseRequest {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;
}
