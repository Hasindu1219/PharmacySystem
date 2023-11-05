package com.pharmacyshopmanagementsystem.Employee;

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

    public static ObservableList<Medicament> getCustomerDetails() {
        ObservableList<Medicament> Cusmedicament = FXCollections.observableArrayList();
        String query = "select * from customer";

        try {
            connection=dbConnection.dbConnect();
            statement = connection.prepareStatement(query, 1);
            resultSet = statement.getGeneratedKeys();
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String cus_Id = resultSet.getString("customer_id");
                String cus_Fname = resultSet.getString("f_name");
                String cus_Lname = resultSet.getString("l_name");
                String cus_dob = resultSet.getString("DOB");
                String cus_address = resultSet.getString("c_address");
                String cus_tpno = resultSet.getString("c_tp_no");

                Medicament Cus = new Medicament(cus_Id,cus_Fname,cus_Lname,cus_dob,cus_address,cus_tpno);

                Cusmedicament.add(Cus);
            }

            return Cusmedicament;
        } catch (SQLException var10) {
            throw new RuntimeException(var10);
        }
    }

    public static ObservableList<MedicineTableAdd> getMedicineDetails() {
        ObservableList<MedicineTableAdd> Medicine = FXCollections.observableArrayList();
        String query = "select * from medicine";

        try {
            connection=dbConnection.dbConnect();
            statement = connection.prepareStatement(query, 1);
            resultSet = statement.getGeneratedKeys();
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String med_Id = resultSet.getString("medicine_id");
                String med_Name = resultSet.getString("medicine_name");
                String med_Sid = resultSet.getString("supplier_id");
                String med_Desciption = resultSet.getString("description");
                String med_Uprice = resultSet.getString("unit_price");
                String med_Exp = resultSet.getString("exp_date");

                MedicineTableAdd Med = new MedicineTableAdd(med_Id,med_Name,med_Sid,med_Desciption,med_Uprice,med_Exp);

                Medicine.add(Med);
            }

            return Medicine;
        } catch (SQLException var10) {
            throw new RuntimeException(var10);
        }
    }

}



