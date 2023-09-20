package com.luv2code.cruddemo.TestStudent;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDAOTest
{
    private StudentDAO studentDAO;

    @Autowired
    public StudentDAOTest(StudentDAO studentDAO)
    {
        this.studentDAO = studentDAO;
    }

    @Test
    void saveStudent()
    {
        // Create the student object
        System.out.println("Creating new student object");
        Student tempStudent = new Student("Paul", "Dow", "paul@luv2code.com");

        //save the student object
        System.out.println("Saving the new Student");
        studentDAO.save(tempStudent);

        // Display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
