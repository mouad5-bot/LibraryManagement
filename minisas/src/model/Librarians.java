package model;

import database.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Librarians extends Person{
    public Librarians(String name){
        this.name = name;
    }

}
