package com.flickfinder.controller;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Person;
import io.javalin.http.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for the Person Controller.
 */
class PersonControllerTest {

    private Context ctx;
    private PersonDAO personDAO;
    private PersonController personController;

    @BeforeEach
    void setUp() {
        personDAO = mock(PersonDAO.class);
        ctx = mock(Context.class);
        personController = new PersonController(personDAO);

        when(ctx.json(any())).thenReturn(ctx);
        when(ctx.status(anyInt())).thenReturn(ctx);
    }

    @Test
    void testGetAllPeople() {
        personController.getAllPeople(ctx);
        try {
            verify(personDAO).getAllPeople();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testThrows500ExceptionWhenGetAllPeopleFails() throws SQLException {
        when(personDAO.getAllPeople()).thenThrow(new SQLException());
        personController.getAllPeople(ctx);
        verify(ctx).status(500);
    }

    @Test
    void testGetPersonById() throws SQLException {
        when(ctx.pathParam("id")).thenReturn("1");
        when(personDAO.getPersonById(1)).thenReturn(new Person(1, "Tomos Kelleher", 2005));
        personController.getPersonById(ctx);
        verify(personDAO).getPersonById(1);
    }

    @Test
    void testThrows500ExceptionWhenGetPersonByIdFails() throws SQLException {
        when(ctx.pathParam("id")).thenReturn("1");
        when(personDAO.getPersonById(1)).thenThrow(new SQLException());
        personController.getPersonById(ctx);
        verify(ctx).status(500);
    }

    @Test
    void testThrows404IfPersonNotFound() throws SQLException {
        when(ctx.pathParam("id")).thenReturn("1");
        when(personDAO.getPersonById(1)).thenReturn(null);
        personController.getPersonById(ctx);
        verify(ctx).status(404);
    }
}
