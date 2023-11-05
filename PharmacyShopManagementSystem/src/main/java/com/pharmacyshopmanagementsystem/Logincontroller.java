package com.pharmacyshopmanagementsystem;

import com.pharmacyshopmanagementsystem.DBconnection.dbConnection;
import com.pharmacyshopmanagementsystem.Employee.EmployeeControlPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.pharmacyshopmanagementsystem.user.UserDetails.setUserDetails;

public class Logincontroller implements Initializable {
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

        Alert alert;

        if(Username.isEmpty() || Password.isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank feilds");
            alert.showAndWait();
            alert.setX(0.5);
            alert.setY(0.5);

        }else {

            try {

                con = dbConnection.dbConnect();
                stmt = con.createStatement();

                String query = "SELECT * FROM admin";

                ResultSet rs1 = stmt.executeQuery(query);


                while (rs1.next()) {

                    if (Username.equals(rs1.getString(1)) && Password.equals(rs1.getString(4))) {
                        flag = 1;

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Logged to Admin Panel");
                        alert.showAndWait();


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

                while (rs2.next()) {
                    if (Username.equals(rs2.getString(1)) && Password.equals(rs2.getString(6))) {
                        flag = 1;

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Logged to Employee Panel");
                        alert.showAndWait();

                        setUserDetails(Username,Password);


                        Parent root = FXMLLoader.load(getClass().getResource("Employee/EmployeeControlPanel.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    }
                }

                if(flag == 0)
                {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username or Password");
                    alert.showAndWait();
                    UsernameTextField.setText("");
                    PasswordTextField.setText("");
                }

            } catch (SQLException ex) {
                System.out.println("Error in displaying all users" + ex.getMessage());
            }
        }
    }

    public void Clear(ActionEvent event) throws IOException
    {
        UsernameTextField.setText("");
        PasswordTextField.setText("");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}









