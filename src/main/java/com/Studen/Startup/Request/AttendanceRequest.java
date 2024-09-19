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
public class AttendanceRequest {

    private LocalDate date;
    private Integer studentId;
    private Integer courseId;
}
