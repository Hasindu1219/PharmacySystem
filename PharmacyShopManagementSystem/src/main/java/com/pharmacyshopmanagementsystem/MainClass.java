package com.pharmacyshopmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {

//        Image i1 = new Image(getClass().getResourceAsStream("/icons/admin.png"));
//        Image i2 = new Image(getClass().getResourceAsStream("/icons/ad.png"));
//        Image i3 = new Image(getClass().getResourceAsStream("/icons/customer.png"));
//        Image i4 = new Image(getClass().getResourceAsStream("/icons/staff.png"));
//        Image i5 = new Image(getClass().getResourceAsStream("/icons/settings.png"));
//        Image i6 = new Image(getClass().getResourceAsStream("/icons/medicine.png"));
//        Image i7 = new Image(getClass().getResourceAsStream("/icons/financial.png"));
//        Image i8 = new Image(getClass().getResourceAsStream("/icons/reporting.png"));
//
//        stage.getIcons().addAll(i1, i2, i3, i4, i5,i6,i7,i8);


        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("LoginContainer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}