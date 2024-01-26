package com.example.StudentApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Student {
    @Id
    private int studentId;
    @NotBlank
    @Size(min = 2,message = "firstname is required at least 2 characters")
    private String firstName;
    private String lastName;
    private double phoneNumber;
    private String address;
    private int standard;
@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
        flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;





}
