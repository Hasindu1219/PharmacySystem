package com.pharmacyshopmanagementsystem.Admin;

import com.pharmacyshopmanagementsystem.DBconnection.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicamentDB extends Medicament {
    static Connection connection;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public MedicamentDB() {
    }


    public static ObservableList<Medicament> getMedicament() {
        ObservableList<Medicament> medicament = FXCollections.observableArrayList();
        String query = "select * from employee";

        try {
            connection=dbConnection.dbConnect();
            statement = connection.prepareStatement(query, 1);
            resultSet = statement.getGeneratedKeys();
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String med_Id = resultSet.getString("emp_id");
                String med_Fname = resultSet.getString("f_name");
                String med_Tpno = resultSet.getString("e_tp_no");
                String med_email = resultSet.getString("e_email");
                Medicament Med = new Medicament(med_Id,med_Fname,med_Tpno,med_email);

                //System.out.println("@@@@@@@@@@@@@@@");
                //System.out.println(med_Id);
                //System.out.println(med_Fname);
                medicament.add(Med);
            }

            return medicament;
        } catch (SQLException var10) {
            throw new RuntimeException(var10);
        }
    }

    public static ObservableList<Suppliertable> getMedicament1() {
        ObservableList<Suppliertable> Suppliertable = FXCollections.observableArrayList();
        String query = "select * from supplier";

        try {
            connection=dbConnection.dbConnect();
            statement = connection.prepareStatement(query, 1);
            resultSet = statement.getGeneratedKeys();
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String sup_Id = resultSet.getString("supplier_id");
                String sup_Fname = resultSet.getString("f_name");
                String sup_Tpno = resultSet.getString("s_tp_no");
                String sup_address = resultSet.getString("s_address");
                Suppliertable Med = new Suppliertable(sup_Id,sup_Fname,sup_Tpno,sup_address);

                //System.out.println("@@@@@@@@@@@@@@@");
                //System.out.println(med_Id);
                //System.out.println(med_Fname);
                Suppliertable.add(Med);
            }

            return Suppliertable;
        } catch (SQLException var10) {
            throw new RuntimeException(var10);
        }
    }

    public static ObservableList<Empattendance> getMedicament3() {
        ObservableList<Empattendance> Empattendance = FXCollections.observableArrayList();
        String query = "select * from attendance";

        try {
            connection=dbConnection.dbConnect();
            statement = connection.prepareStatement(query, 1);
            resultSet = statement.getGeneratedKeys();
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String emp_Id = resultSet.getString("emp_id");
                String emp_Date = resultSet.getString("date");

                Empattendance Med = new Empattendance(emp_Id,emp_Date);

                //System.out.println("@@@@@@@@@@@@@@@");
                //System.out.println(med_Id);
                //System.out.println(med_Fname);
                Empattendance.add(Med);
            }

            return Empattendance;
        } catch (SQLException var10) {
            throw new RuntimeException(var10);
        }
    }

}



