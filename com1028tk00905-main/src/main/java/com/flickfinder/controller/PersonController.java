package com.flickfinder.controller;

import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Movie;
import com.flickfinder.model.Person;
import io.javalin.http.Context;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Controller for handling people-related HTTP requests.
 */
public class PersonController {

    private final PersonDAO personDAO;

    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void getAllPeople(Context ctx) {
        try {
            ctx.json(personDAO.getAllPeople());
        } catch (SQLException e) {
            ctx.status(500).json(Map.of("error", "Database error"));
        }
    }

    public void getPersonById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try {
            Person person = personDAO.getPersonById(id);
            if (person != null) {
                ctx.json(person);
            } else {
                ctx.status(404).json(Map.of("error", "Person not found"));
            }
        } catch (SQLException e) {
            ctx.status(500).json(Map.of("error", "Database error"));
        }
    }

    public void getMoviesStarringPerson(Context ctx) {
        int personId = Integer.parseInt(ctx.pathParam("id"));
        try {
            List<Movie> movies = personDAO.getMoviesForPerson(personId);
            if (!movies.isEmpty()) {
                ctx.json(movies);
            } else {
                ctx.status(404).json(Map.of("error", "No movies found for this person"));
            }
        } catch (SQLException e) {
            ctx.status(500).json(Map.of("error", "Database error"));
        }
    }
}
