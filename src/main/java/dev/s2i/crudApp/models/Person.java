package dev.s2i.crudApp.models;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Repository
@Entity
@Table(name = "users")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Not should be empty")
    @Size(min = 2, max = 30, message = "Name should be 2 or 30 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Not should be empty")
    @Size(min = 2, max = 50, message = "Name should be 2 or 50 characters")
    private String surname;

    @Column(name = "email", unique = true)
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
