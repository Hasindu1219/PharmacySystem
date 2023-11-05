package com.pharmacyshopmanagementsystem.user;

import com.pharmacyshopmanagementsystem.DBconnection.dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDetails {
    private static String myEID =null;
    private static String myPassword=null;
    private static String Fname=null;
    private static String Lname=null;
    static Connection con;
    static Statement stmt;


    public static void setUserDetails(String eid,String password){
        myEID =eid;
        myPassword=password;

        try {
            con = dbConnection.dbConnect();
            stmt = con.createStatement();

            String query = "SELECT * FROM employee where emp_id ="+myEID+";";

            ResultSet rs1 = stmt.executeQuery(query);
            rs1.next();

            Fname = rs1.getString("f_name");
            Lname = rs1.getString("l_name");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getUserID() {
        return myEID;
    }
    public static String getPassword() {
        return myPassword;
    }
    public static String getUserName() {
        return Fname +" "+ Lname;
    }


}
