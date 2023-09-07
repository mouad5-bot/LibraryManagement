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
        // preparedStatement.setInt(1, this.author.id );
        preparedStatement.setString(1,  this.name);
        int rowsUpdate = preparedStatement.executeUpdate();
    }

}
