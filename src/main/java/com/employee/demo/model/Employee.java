package com.employee.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("employees")
public class Employee {
    @Id
    private int id;
    private String fullName;
    private String email;
    private String contactNumber;
    private String dob;
    private String age;
    private String salary;

    public Employee(int id, String fullName, String email, String contactNumber, String dob, String age, String salary) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.dob = dob;
        this.age = age;
        this.salary = salary;
    }
}
