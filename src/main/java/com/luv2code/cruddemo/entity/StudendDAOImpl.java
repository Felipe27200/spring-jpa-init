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
public class StudendDAOImpl implements StudentDAO
{
    // Define field for entity manager

    private EntityManager entityManager;

    // Inject entity manager using Constructor Injection

    @Autowired
    public StudendDAOImpl(EntityManager entityManager)
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
}
