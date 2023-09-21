package com.luv2code.cruddemo.entity;

import com.luv2code.cruddemo.dao.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
