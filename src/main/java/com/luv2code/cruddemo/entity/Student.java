package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

/*
* Use entity to emulate the table on
* the Java code and manipulate from it.
* */
@Entity

@Table(name = "student") // Set the table's name on the DB
public class Student
{
    /*
     * +----------------+
     * | Defined Fields |
     * +----------------+
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Set the Autoincrement for Primary Key
    @Column(name = "id") // Set the name of the column
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    /*
     * +---------------------+
     * | Defined Constructor |
     * +---------------------+
     */

    public Student()
    {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /*
     * +---------------------------+
     * | Defined Getters / Setters |
     * +---------------------------+
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * +--------------------+
     * | Defined toString() |
     * +--------------------+
     */

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
