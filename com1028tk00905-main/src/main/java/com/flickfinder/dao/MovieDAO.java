package com.flickfinder.dao;

import com.flickfinder.model.Movie;
import com.flickfinder.model.Person;
import com.flickfinder.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Data Access Object for the Movie table.
 */
public class MovieDAO {

    private final Connection connection;

    public MovieDAO() {
        Database database = Database.getInstance();
        connection = database.getConnection();
    }

    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM movies LIMIT 50");

        while (rs.next()) {
            movies.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getInt("year")));
        }

        return movies;
    }

    public Movie getMovieById(int id) throws SQLException {
        String sql = "SELECT * FROM movies WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Movie(rs.getInt("id"), rs.getString("title"), rs.getInt("year"));
        }

        return null;
    }

    public List<Person> getStarsForMovie(int movieId) throws SQLException {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT p.id, p.name, p.birth FROM PEOPLE p " +
                     "JOIN STARS s ON p.id = s.person_id " +
                     "WHERE s.movie_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, movieId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    people.add(new Person(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("birth")
                    ));
                }
            }
        }
        return people;
    }
}
