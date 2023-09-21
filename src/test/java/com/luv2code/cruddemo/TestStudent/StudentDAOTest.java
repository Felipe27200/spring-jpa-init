package com.luv2code.cruddemo.TestStudent;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void createMultipleStudents()
    {
        System.out.println("Creating 3 Student objects");

        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student tempStudent3 = new Student("Bonita", "AppleBum", "bonita@luv2code.com");

        // Save the students Objects
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    @Test
    void readStudent()
    {
        // Create a student object
        System.out.println("Creating new Student");
        Student studentTemp = new Student("Daffy", "Duck", "daffy@luv2code.com");

        // Save the student
        System.out.println("Saving the student");
        studentDAO.save(studentTemp);

        // Display id of the saved student
        int id = studentTemp.getId();
        System.out.println("Saved student. Generated id: " + id);

        // Retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + id);
        Student myStudent = studentDAO.findById(id);

        // Display student
        System.out.println("Found the student\n" + myStudent);
    }

    @Test
    void queryForStudents()
    {
        // Get a list of students
        List<Student> students = studentDAO.findAll();

        // Display list of students
        for (Student student: students)
        {
            System.out.println(student + "\n");
        }
    }

    @Test
    void queryForStudentsByLastName()
    {
        // Get a list of students
        List<Student> students = studentDAO.findByLastName("Duck");

        // Display list of students
        for (Student student: students)
        {
            System.out.println(student + "\n");
        }
    }

    @Test
    void updateStudent()
    {
        int studentId = 1;

        // 1. Retrieve student based on the id: primary key
        System.out.println("Getting my student with id: " + studentId);
        Student student = studentDAO.findById(studentId);

        // 2. Change first name
        System.out.println("Updating student...");

        if (student.getFirstName().equals("John"))
            student.setFirstName("Scooby");
        else
            student.setFirstName("John");

        // 3. Update the student
        // In the previous step we change the entity object,
        // now we will change the record in the DB.
        studentDAO.update(student);

        // 4. Display the updated student
        System.out.println("My updated student: " + student);
    }
}
