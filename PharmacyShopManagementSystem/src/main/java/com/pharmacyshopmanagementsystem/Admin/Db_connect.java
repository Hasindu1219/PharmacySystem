package com.pharmacyshopmanagementsystem.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_connect {
    Connection DBConet(){
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
            System.out.println("ok");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return c;

    }
}

