package com.flickfinder.dao;

import com.flickfinder.model.Movie;
import com.flickfinder.model.Person;
import com.flickfinder.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Data Access Object for the People table.
 */
public class PersonDAO {

    private final Connection connection;

    public PersonDAO() {
        this.connection = Database.getInstance().getConnection();
    }

    public List<Person> getAllPeople() throws SQLException {
        List<Person> people = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT id, name, birth FROM PEOPLE LIMIT 50");

        while (rs.next()) {
            people.add(new Person(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("birth")
            ));
        }

        return people;
    }

    public Person getPersonById(int id) throws SQLException {
        String sql = "SELECT id, name, birth FROM PEOPLE WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Person(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("birth")
            );
        }

        return null;
    }

    public List<Movie> getMoviesForPerson(int personId) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT m.id, m.title, m.year FROM MOVIES m " +
                     "JOIN STARS s ON m.id = s.movie_id " +
                     "WHERE s.person_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, personId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    movies.add(new Movie(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getInt("year")
                    ));
                }
            }
        }

        return movies;
    }
}
