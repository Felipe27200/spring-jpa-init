package com.luv2code.cruddemo.entity;

import com.luv2code.cruddemo.dao.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* Specialized annotation for repositories
*
* Support Component Scanning
*
* Translate JDBC exceptions
* */
@Repository
public class StudentDAOImpl implements StudentDAO
{
    // Define field for entity manager

    private EntityManager entityManager;

    // Inject entity manager using Constructor Injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    // Implement save() method
    @Override
    @Transactional // Let us do the action in the database | execute Query
    public void save(Student student)
    {
        // Saves the student
        entityManager.persist(student);
    }

    // Implement save() method
    @Override
    @Transactional // Let us do the action in the database | execute Query
    public Student findById(Integer id)
    {
        /*
        * +-------------------+
        * | Find Record by ID |
        * +-------------------+
        *
        * The entity manager makes the persistence
        * with the DB, in this case it needs the class
        * of the entity related with the table and the id
        * or primary key
        * */
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll()
    {
        /*
        * +-----------+
        * | USE QUERY |
        * +-----------+
        *
        * Here we don't refer to the DB entities with
        * refer the Entities defined in Java and their properties.
        * So, this way Java recognize the table and applies the query.
        *
        * We refer the JPA entities.
        * JPQL syntax is based in entity name and its properties.
        * */
        // TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        /* -- lastName refers to the field in the entity Student */
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName)
    {
        // Create Query
        TypedQuery<Student> query =
            // :theData in field for values and the semicolon are necessaries
            entityManager.createQuery("FROM Student WHERE lastName = :theData", Student.class);

        // Set Parameters for the query
        // The first argument is the name field and the second is the value we will look for
        query.setParameter("theData", lastName);

        return query.getResultList();
    }
}
