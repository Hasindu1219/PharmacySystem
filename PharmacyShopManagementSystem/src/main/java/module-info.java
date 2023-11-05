module com.example.pharmacyshopmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires kotlin.stdlib;


    opens com.pharmacyshopmanagementsystem to javafx.fxml;
    exports com.pharmacyshopmanagementsystem;
    exports com.pharmacyshopmanagementsystem.Admin;
    opens com.pharmacyshopmanagementsystem.Admin to javafx.fxml;
    exports com.pharmacyshopmanagementsystem.Employee;
    opens com.pharmacyshopmanagementsystem.Employee to javafx.fxml;

}