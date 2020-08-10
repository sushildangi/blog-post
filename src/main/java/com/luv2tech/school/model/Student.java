package com.luv2tech.school.model;

import com.luv2tech.model.base.BaseAudit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@Setter
@Getter
@ToString
public class Student extends BaseAudit<String> {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String rollNumber;
    private LocalDate admissionDate;
    private ClassName className;
    private Section section;

}
