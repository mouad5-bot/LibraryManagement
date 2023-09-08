package model;

import database.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Borrower extends Person{
    public Borrower(String name){
        this.name = name;
    }

    public void addBorrower() throws SQLException {
        String sql = "INSERT INTO borrower (name) VALUES(?)";
        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
        preparedStatement.setString(1,  this.name);
        int rowsUpdate = preparedStatement.executeUpdate();
    }
}
