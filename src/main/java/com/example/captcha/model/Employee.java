package com.example.captcha.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double salary;

    @Transient
    private String captcha;

    @Transient
    private String hidden;

    @Transient
    private String image;
}
