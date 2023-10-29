module com.example.pharmacyshopmanagementsystem {
   // requires javafx.controls;
    //requires javafx.fxml;
    requires java.sql;


    opens com.pharmacyshopmanagementsystem to javafx.fxml;
    exports com.pharmacyshopmanagementsystem;
    exports com.pharmacyshopmanagementsystem.Admin;
    opens com.pharmacyshopmanagementsystem.Admin to javafx.fxml;
}