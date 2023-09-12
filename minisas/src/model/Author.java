package model;

import database.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Author extends Person{
    private int personId;

    public Author(){}
    public Author(String name){
        this.name = name;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public void searchAuthor(String name){
        try {
            String sql="SELECT * FROM author a inner join person p on a.personId = p.id  WHERE p.name like ?";
            PreparedStatement statement = Connection.connect().prepareStatement(sql);
            statement.setString(1, "%" + name + "%" );
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("p.id");
                String nameBorrower =  resultSet.getString("p.name");

                System.out.println("id: " + id + ", name: " + nameBorrower );
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());

        }
    }

    public int findAuthorId(int id) throws SQLException {
        String sql = "SELECT a.id FROM author a inner join person p on a.personId = p.id WHERE p.id = ?";
        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        int res = 0;
        if (resultSet.next()) {
            res = resultSet.getInt("a.id");
        }
        resultSet.close();
        preparedStatement.close();
        return res;
    }
}



