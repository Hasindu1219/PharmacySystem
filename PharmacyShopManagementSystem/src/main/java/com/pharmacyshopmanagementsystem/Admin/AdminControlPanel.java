package com.pharmacyshopmanagementsystem.Admin;

import com.pharmacyshopmanagementsystem.MainClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.css.CssParser;

import java.io.IOException;


public class AdminControlPanel {
    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private Button dashbtn;

    @FXML
    private Button staffbtn;

    @FXML
    private Button customerbtn;

    @FXML
    private Button medicinebtn;

    @FXML
    private Button financebtn;

    @FXML
    private Button supplierbtn;

    @FXML
    private Button reportbtn;

    @FXML
    private Button logoutbtn;

    @FXML
    private Button settingstbtn;

    @FXML
    private AnchorPane dashAP;




    @FXML
    void dashbutton(ActionEvent event)
    {
        if(event.getSource() == dashbtn)
        {
            dashAP.setVisible(false);

        }

        else
        {
            dashAP.setVisible(false);
        }

    }

    @FXML
    void check()
    {
        System.out.println("clicked");
    }

    @FXML
    void logout() throws IOException {

//        stage.close();
//        MainClass.launch();
//
//
////        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("LoginContainer.fxml"));
////        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
////        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
////        stage.setScene(scene);
////        stage.show();



    }


}

