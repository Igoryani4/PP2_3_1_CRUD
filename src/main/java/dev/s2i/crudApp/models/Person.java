package dev.s2i.crudApp.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "Not should be empty")
    @Size(min = 2, max = 30, message = "Name should be 2 or 30 characters")
    private String name;

    @NotEmpty(message = "Not should be empty")
    @Size(min = 2, max = 50, message = "Name should be 2 or 50 characters")
    private String surname;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "email should be valid")
    private String email;


    public Person() {
    }

    public Person(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
