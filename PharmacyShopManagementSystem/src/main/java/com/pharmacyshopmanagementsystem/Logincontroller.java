package com.pharmacyshopmanagementsystem;

import com.pharmacyshopmanagementsystem.DBconnection.dbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Logincontroller {
    @FXML
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField UsernameTextField;

    @FXML
    private PasswordField PasswordTextField;

    private Parent root;
    @FXML
    private BorderPane UserContainer;
    @FXML
    private Button LoginBTN;

    @FXML
    private Button ClearBTN;

    private String Username;
    private String Password;

    public String id;
    public String name1;
    public String address;

    public void Click(ActionEvent event) throws IOException {

        Connection con;


        Statement stmt;
        int flag = 0;

        Username = UsernameTextField.getText();
        Password = PasswordTextField.getText();

        try {
//
            con= dbConnection.dbConnect();
            stmt = con.createStatement();

            String query = "SELECT * FROM admin";

            ResultSet rs1 = stmt.executeQuery(query);

            while (rs1.next())
            {
                if (Username.equals(rs1.getString(1)) && Password.equals(rs1.getString(4)))
                {
                    flag = 1;

                    Parent root = FXMLLoader.load(getClass().getResource("Admin/AdminControlPanel.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
                    stage.setScene(scene);
                    stage.show();

                }
            }


            String query1 = "SELECT * FROM employee";

            ResultSet rs2 = stmt.executeQuery(query1);

            while (rs2.next())
            {
                if (Username.equals(rs2.getString(1)) && Password.equals(rs2.getString(6)))
                {
                    flag = 1;
                    Parent root = FXMLLoader.load(getClass().getResource("jj.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }
            }


        } catch (SQLException ex) {
            System.out.println("Error in displaying all users" + ex.getMessage());
        }



        if(flag == 0)
        {
            System.out.println("Error");
        }

    }

    public void Clear(ActionEvent event) throws IOException
    {
        UsernameTextField.setText("");
        PasswordTextField.setText("");
    }


    }









