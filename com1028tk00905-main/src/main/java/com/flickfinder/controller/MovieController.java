package com.flickfinder.controller;

import java.sql.SQLException;
import java.util.List;

import com.flickfinder.dao.MovieDAO;
import com.flickfinder.model.Movie;
import com.flickfinder.model.Person;

import io.javalin.http.Context;

/**
 * The controller for the movie endpoints.
 */
public class MovieController {

    private final MovieDAO movieDAO;

    public MovieController(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    public void getAllMovies(Context ctx) {
        try {
            ctx.json(movieDAO.getAllMovies());
        } catch (SQLException e) {
            ctx.status(500);
            ctx.result("Database error");
            e.printStackTrace();
        }
    }

    public void getMovieById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try {
            Movie movie = movieDAO.getMovieById(id);
            if (movie == null) {
                ctx.status(404);
                ctx.result("Movie not found");
                return;
            }
            ctx.json(movie);
        } catch (SQLException e) {
            ctx.status(500);
            ctx.result("Database error");
            e.printStackTrace();
        }
    }

    public void getPeopleByMovieId(Context ctx) {
        int movieId = Integer.parseInt(ctx.pathParam("id"));
        try {
            List<Person> stars = movieDAO.getStarsForMovie(movieId);
            if (stars.isEmpty()) {
                ctx.status(404);
                ctx.result("No stars found for this movie");
            } else {
                ctx.json(stars);
            }
        } catch (SQLException e) {
            ctx.status(500);
            ctx.result("Database error");
            e.printStackTrace();
        }
    }
}
