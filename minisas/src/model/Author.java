package model;

import database.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Author extends Person{
    public Author(String name){
        this.name = name;
    }
    public void addAuthor() throws SQLException {
        String sql = "INSERT INTO Author (name) VALUES(?)";
        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
        preparedStatement.setString(1,  this.name);
        int rowsUpdate = preparedStatement.executeUpdate();
    }
//    public void addAuthor() throws SQLException
//    {
//        try {
//        // Establish a database connection
//        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
//
//        // Insert a person as an author
//        String insertPersonSQL = "INSERT INTO Person (name) VALUES (?)";
//
//        // Use a PreparedStatement to safely insert the person's name
//        PreparedStatement insertPersonStatement = connection.prepareStatement(insertPersonSQL);
//        insertPersonStatement.setString(1, "John Doe");
//
//        // Execute the insert query
//        insertPersonStatement.executeUpdate();
//
//        // Retrieve the person's ID
//        String getLastInsertedIdSQL = "SELECT LAST_INSERT_ID() AS id";
//
//        // Use a PreparedStatement to execute the SELECT query
//        PreparedStatement getLastInsertedIdStatement = connection.prepareStatement(getLastInsertedIdSQL);
//
//        // Execute the SELECT query and retrieve the result
//        ResultSet resultSet = getLastInsertedIdStatement.executeQuery();
//
//        // Get the person's ID from the result
//        int personId = -1;
//        if (resultSet.next()) {
//            personId = resultSet.getInt("id");
//        }
//
//        // Insert the person's ID into the AuthorLink table
//        String insertAuthorLinkSQL = "INSERT INTO AuthorLink (personId) VALUES (?)";
//
//        // Use a PreparedStatement to safely insert the person's ID
//        PreparedStatement insertAuthorLinkStatement = connection.prepareStatement(insertAuthorLinkSQL);
//        insertAuthorLinkStatement.setInt(1, personId);
//
//        // Execute the insert query
//        insertAuthorLinkStatement.executeUpdate();
//
//        // Close the resources
//        insertPersonStatement.close();
//        getLastInsertedIdStatement.close();
//        insertAuthorLinkStatement.close();
//        connection.close();
//
//        System.out.println("Person inserted as an author.");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}



