package com.pharmacyshopmanagementsystem.customer;

import com.pharmacyshopmanagementsystem.DBconnection.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedicamentSearchTable extends Medicament{
    static Connection connection;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public MedicamentSearchTable(){}

    public static ObservableList<Medicament> getMedicamentByID(String id) {
        ObservableList<Medicament> medicament = FXCollections.observableArrayList();
        String query = "select * from customer where customer_id='"+id+"'";

        try {
            connection= dbConnection.dbConnect();
            statement = connection.prepareStatement(query, 1);
            resultSet = statement.getGeneratedKeys();
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String cid = resultSet.getString(1);
                String FirstName = resultSet.getString(2);
                String LastName = resultSet.getString(3);
                String dob = resultSet.getString(4);
                String address = resultSet.getString(5);
                String tp = resultSet.getString(6);

                Medicament Med = new Medicament(cid,FirstName,LastName,dob,address,tp);

                System.out.println(cid+"|"+FirstName+"|"+LastName+"|"+dob+"|"+address+"|"+tp);
                medicament.add(Med);
            }

            return medicament;

        } catch (Exception var10) {
            throw new RuntimeException(var10);
        }
    }
    public static ObservableList<Medicament> getMedicamentByFirstName(String firstName) {
        ObservableList<Medicament> medicament = FXCollections.observableArrayList();
        String query = "select * from customer where f_name='"+firstName+"'";

        try {
            connection= dbConnection.dbConnect();
            statement = connection.prepareStatement(query, 1);
            resultSet = statement.getGeneratedKeys();
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String cid = resultSet.getString(1);
                String FirstName = resultSet.getString(2);
                String LastName = resultSet.getString(3);
                String dob = resultSet.getString(4);
                String address = resultSet.getString(5);
                String tp = resultSet.getString(6);

                Medicament Med = new Medicament(cid,FirstName,LastName,dob,address,tp);

                System.out.println(cid+"|"+FirstName+"|"+LastName+"|"+dob+"|"+address+"|"+tp);
                medicament.add(Med);
            }

            return medicament;

        } catch (Exception var10) {
            throw new RuntimeException(var10);
        }
    }
    public static ObservableList<Medicament> getMedicamentByLastName(String lastName) {
        ObservableList<Medicament> medicament = FXCollections.observableArrayList();
        String query = "select * from customer where l_name='"+lastName+"'";

        try {
            connection= dbConnection.dbConnect();
            statement = connection.prepareStatement(query, 1);
            resultSet = statement.getGeneratedKeys();
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String cid = resultSet.getString(1);
                String FirstName = resultSet.getString(2);
                String LastName = resultSet.getString(3);
                String dob = resultSet.getString(4);
                String address = resultSet.getString(5);
                String tp = resultSet.getString(6);

                Medicament Med = new Medicament(cid,FirstName,LastName,dob,address,tp);

                System.out.println(cid+"|"+FirstName+"|"+LastName+"|"+dob+"|"+address+"|"+tp);
                medicament.add(Med);
            }

            return medicament;

        } catch (Exception var10) {
            throw new RuntimeException(var10);
        }
    }
}
