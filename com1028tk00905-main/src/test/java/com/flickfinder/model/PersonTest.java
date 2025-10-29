package com.flickfinder.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for the Person Model.
 */
public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person(1, "Tomos Kelleher", 2006);
    }

    @Test
    public void testPersonCreated() {
        assertEquals(1, person.getId());
        assertEquals("Tomos Kelleher", person.getName());
        assertEquals(2006, person.getBirth());
    }

    @Test
    public void testPersonSetters() {
        person.setId(2);
        person.setName("Mark Kelleher");
        person.setBirth(1975);
        assertEquals(2, person.getId());
        assertEquals("Mark Kelleher", person.getName());
        assertEquals(1975, person.getBirth());
    }
}
