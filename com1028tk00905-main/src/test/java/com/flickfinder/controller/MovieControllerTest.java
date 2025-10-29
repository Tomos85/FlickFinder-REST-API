package com.flickfinder.controller;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.flickfinder.dao.MovieDAO;

import io.javalin.http.Context;

/**
 * Test for the Movie Controller.
 */
class MovieControllerTest {

    private Context ctx;
    private MovieDAO movieDAO;
    private MovieController movieController;

    @BeforeEach
    void setUp() {
        movieDAO = mock(MovieDAO.class);
        ctx = mock(Context.class);
        movieController = new MovieController(movieDAO);

        when(ctx.json(any())).thenReturn(ctx);
        when(ctx.status(anyInt())).thenReturn(ctx);
    }

    @Test
    void testGetAllMovies() {
        movieController.getAllMovies(ctx);
        try {
            verify(movieDAO).getAllMovies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testThrows500ExceptionWhenGetAllDatabaseError() throws SQLException {
        when(movieDAO.getAllMovies()).thenThrow(new SQLException());
        movieController.getAllMovies(ctx);
        verify(ctx).status(500);
    }

    @Test
    void testGetMovieById() {
        when(ctx.pathParam("id")).thenReturn("1");
        movieController.getMovieById(ctx);
        try {
            verify(movieDAO).getMovieById(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testThrows500ExceptionWhenGetByIdDatabaseError() throws SQLException {
        when(ctx.pathParam("id")).thenReturn("1");
        when(movieDAO.getMovieById(1)).thenThrow(new SQLException());
        movieController.getMovieById(ctx);
        verify(ctx).status(500);
    }

    @Test
    void testThrows404ExceptionWhenNoMovieFound() throws SQLException {
        when(ctx.pathParam("id")).thenReturn("1");
        when(movieDAO.getMovieById(1)).thenReturn(null);
        movieController.getMovieById(ctx);
        verify(ctx).status(404);
    }
}
