package com.peterjxl.learnspringbootwebadmin.bean;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private int gender;
    private int grade;
    private int score;
}
