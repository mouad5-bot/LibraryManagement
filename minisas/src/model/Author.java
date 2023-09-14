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
        String sql = "INSERT INTO Author (personId) VALUES (LAST_INSERT_ID())";
        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
        //preparedStatement.setString(1,  this.name);
        preparedStatement.executeUpdate();
        System.out.println("The author has been added successfully");
    }

    public int findAuthorId(int personId){
        return personId;
    }

    public void searchAuthor(String name){
        try {
            String sql="SELECT * FROM author a inner join person p on a.personId = p.id  WHERE p.name like ?";
            PreparedStatement statement = Connection.connect().prepareStatement(sql);
            statement.setString(1, "%" + name + "%" );
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("p.id");
                String nameBorrower =  resultSet.getString("p.name");

                System.out.println("number: " + id + ", name: " + nameBorrower );
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());

        }
    }

    public int findAuthorIdByName(String name) throws SQLException {
        String sql = "SELECT * FROM author a inner join person p on a.personId = p.id WHERE p.name = ?";
        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        int res = 0;
        if (resultSet.next()) {
            res = resultSet.getInt("a.id");
        }
        resultSet.close();
        preparedStatement.close();
        return res;
    }

    public void updateAuthor(int id, String name)throws SQLException {
        String sql = "UPDATE author a inner join person p on a.personId = p.id SET p.name=? WHERE a.id = ?";
        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);

        preparedStatement.executeUpdate();

    }
}



