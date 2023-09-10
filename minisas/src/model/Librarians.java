package model;

import database.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Librarians extends Person{
    private int personId;
    public Librarians(String name){
        this.name = name;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
