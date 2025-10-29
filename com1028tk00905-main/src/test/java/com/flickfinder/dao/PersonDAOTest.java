package com.flickfinder.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.flickfinder.model.Person;
import com.flickfinder.util.Database;
import com.flickfinder.util.Seeder;

class PersonDAOTest {

    private PersonDAO personDAO;
    private Seeder seeder;

    @BeforeEach
    void setUp() {
        var url = "jdbc:sqlite::memory:";
        seeder = new Seeder(url);
        Database.getInstance(seeder.getConnection());
        personDAO = new PersonDAO();
    }

    @Test
    void testGetAllPeople() {
        try {
            List<Person> people = personDAO.getAllPeople();
            assertEquals(5, people.size()); 
        } catch (SQLException e) {
            fail("SQLException thrown");
            e.printStackTrace();
        }
    }

    @Test
    void testGetPersonById() {
        try {
            Person person = personDAO.getPersonById(1);
            assertEquals("Tim Robbins", person.getName()); 
        } catch (SQLException e) {
            fail("SQLException thrown");
            e.printStackTrace();
        }
    }

    @Test
    void testGetPersonByInvalidId() {
        try {
            Person person = personDAO.getPersonById(1000);
            assertEquals(null, person);
        } catch (SQLException e) {
            fail("SQLException thrown");
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        seeder.closeConnection();
    }
}
