package com.example.demo.model;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

public class UserDTO {
    private Integer id;

    @NotBlank(message = "FirstName not empty")
    @Size (min = 5, max = 50, message = "Length from 5 to 50")
    private String firstName;

    @NotBlank(message = "LastName not empty")
    @Size (min = 5, max = 50, message = "Length from 5 to 50")
    private String lastName;

    @NotBlank(message = "Phone number not empty")
    @Pattern(regexp = "^0[0-9]{9,10}$",message = "Phone number is a number")
    private String phoneNumber;

    @NotNull(message = "Age not empty")
    @Min(value = 18, message = "Age greater than 18")
    private Integer age;


    @NotEmpty(message = "Email not empty")
    @Email(message = "Email not follow the rules")
    protected String email;

    public UserDTO() {
    }

    public UserDTO(Integer id, @NotBlank(message = "FirstName not empty") @Size(min = 5, max = 50, message = "Length from 5 to 50") String firstName, @NotBlank(message = "LastName not empty") @Size(min = 5, max = 50, message = "Length from 5 to 50") String lastName, @NotBlank(message = "Phone number not empty") @Pattern(regexp = "^0[0-9]{9,10}$", message = "Phone number is a number") String phoneNumber, @NotNull(message = "Age not empty") @Min(value = 18, message = "Age greater than 18") Integer age, @NotEmpty(message = "Email not empty") @Email(message = "Email not follow the rules") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
