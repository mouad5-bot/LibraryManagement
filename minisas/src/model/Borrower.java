package model;

import database.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Borrower extends Person{
    private int personId;

    public Borrower(){
        super();
    }
    public Borrower(int id , String name ,int personId){
        super(id,name);
        this.personId = personId ;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void addBorrower(String name) throws SQLException {
        String sql = "INSERT INTO borrower (name) VALUES(?)";
        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
        preparedStatement.setString(1,  this.name);
        int rowsUpdate = preparedStatement.executeUpdate();
    }

    public void searchBorrower(String name){
        try {
            String sql="SELECT * FROM borrower b inner join person p on b.personId = p.id  WHERE p.name like ?";
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

    public int findBorrowerById  (int id) throws SQLException {
        String sql = "SELECT * FROM borrower as b WHERE b.personId =?";
        PreparedStatement preparedStatement = Connection.connect().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        resultSet.close();
        preparedStatement.close();
        return 0;
    }
}
