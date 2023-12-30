package com.anujmehla.captcha.model;

import jakarta.persistence.*;
import lombok.Data;


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
