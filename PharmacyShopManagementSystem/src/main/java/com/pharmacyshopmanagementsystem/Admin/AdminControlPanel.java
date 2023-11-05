package com.pharmacyshopmanagementsystem.Admin;

import com.pharmacyshopmanagementsystem.DBconnection.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static javafx.scene.chart.PieChart.*;


public class AdminControlPanel implements Initializable {
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
    private AnchorPane dashStaff;

    @FXML
    private AnchorPane updateAp;
    @FXML
    private AnchorPane removeAP;
    @FXML
    private AnchorPane addAP;

    @FXML
    private Button addbtn;
    @FXML
    private Button removebtn;
    @FXML
    private Button updatebtn;

    @FXML
    private DatePicker getdate;

    @FXML
    private Button searchbtn;


    @FXML
    private TableColumn<Empattendance, String> Aempid;
    @FXML
    private TableColumn<Empattendance, String> empDate;
    @FXML
    private TableView<Empattendance> Atable;

/////////////////////////////table////////////////////

    @FXML
    private TableColumn<Medicament, String> email;

    @FXML
    private TableColumn<Medicament, String> fname;

    @FXML
    private TableColumn<Medicament, String> id;

    @FXML
    private TableColumn<Medicament, String> tpno;

    @FXML
    private TableView<Medicament> table;


    //////////////////////////////////////////////////

    @FXML
    private ComboBox<String> Update_EMP_ID;
    @FXML
    private ComboBox<String> Update_EMP_ID2;
    @FXML
    private ComboBox<String> Update_EMP_ID3;
    @FXML
    private ComboBox<String> UpdateEMP;

    @FXML
    private TextField passwordtf;
    @FXML
    private TextField lnametf;
    @FXML
    private TextField idtf;
    @FXML
    private TextField fnametf;
    @FXML
    private TextField emailtf;
    @FXML
    private TextField tp_notf;
    @FXML
    private Label countlable;


    @FXML
    private TextField updatetextfield1;

    @FXML
    private TextField updatetextfield2;

    @FXML
    private TextField updatetextfield3;

    @FXML
    private TextField updatetextfield4;

    @FXML
    private TextField updatetextfield5;

    @FXML
    private Button enterupdatequery;

    //////////////////////////////////////supplier variable///////////////////
    @FXML
    private AnchorPane supplierAp;
    @FXML
    private AnchorPane removesupplierAP;
    @FXML
    private AnchorPane updatesupplierAP;
    @FXML
    private AnchorPane addsuppplierAP;
    @FXML
    private Button addsupplierbtn;
    @FXML
    private Button updatesupplierbtn;
    @FXML
    private Button removesupplierbtn;
    @FXML
    private Button denter2;
    @FXML
    private TextField supidTX;
    @FXML
    private TextField supfnameTX;
    @FXML
    private TextField SlnameTX;
    @FXML
    private TextField stpTX;
    @FXML
    private TextField semailTX;
    @FXML
    private TextField SaddressTX;
    @FXML
    private Button supplierquery;

    @FXML
    private TextField Updatesupname;
    @FXML
    private TextField Updatesuplname;
    @FXML
    private TextField Updatesupemail;
    @FXML
    private TextField Updatesuptpno;
    @FXML
    private TextField Updateaddress;
    @FXML
    private Button supplierIdsearch;

    @FXML
    private ComboBox<String> Update_EMP_ID4;
    @FXML
    private Label countlable1;

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private PieChart AdminDashPirChart;

    @FXML
    private TableColumn<Suppliertable, String> fname1;
    @FXML
    private TableColumn<Suppliertable, String> id1;

    @FXML
    private TableView<Suppliertable> table1;
    @FXML
    private TableColumn<Suppliertable, String> tpno1;
    @FXML
    private TableColumn<Suppliertable, String> address;



    ///////////////////////////////////////////////////////////////




    @FXML
    private AnchorPane attendeceAP;

    @FXML
    private Button attendencebtn;

    @FXML
    private AnchorPane SettingAp;

    //////////////////////////////admin///////////////

    @FXML
    private TextField ADMINFNAME;

    @FXML
    private TextField ADMINLNAME;
    @FXML
    private TextField ADMINPASSWORD;

    @FXML
    private ComboBox<String> Update_EMP_ID5;

    @FXML
    private Button ADMINSETTING;

    String svalue11;
    String svalue12;
    String svalue13;

    @FXML
    private Label NOTIFICATION1;
    @FXML
    private Label NOTIFICATION2;

    @FXML
    private Label NOTIFICATION3;
    ////////////////////////////////////////////





    @FXML
    private Button denter;
    @FXML
    private Button markattendence;

    @FXML
    private Button enterquery;
    String selectedValue;

    Connection con;

    String svalue1;
    String svalue2;
    String svalue3;
    String svalue4;
    String svalue5;
    String svalue6;
    String svalue7;
    String svalue8;
    String svalue9;
    String svalue10;
    String count;

    String as;






    @FXML
    void dashbutton(ActionEvent event)
    {
        if(event.getSource() == dashbtn)
        {
            dashAP.setVisible(true);
            dashStaff.setVisible(false);
            supplierAp.setVisible(false);
            attendeceAP.setVisible(false);
            SettingAp.setVisible(false);
            count();

        }

        else
        {
            dashAP.setVisible(false);
        }

    }

    ////////////////////////////////staff section///////////////////////////////////////////////////////////////////////////////
    @FXML
    void staffbutton(ActionEvent event)
    {
        if(event.getSource() ==staffbtn)
        {
             dashStaff.setVisible(true);
             dashAP.setVisible(false);
             attendeceAP.setVisible(false);
             supplierAp.setVisible(false);
             SettingAp.setVisible(false);
             showMedicament();
             count();
        }

        else
        {
            dashAP.setVisible(false);
        }

    }

    public void count(){

        Statement stmt6;

        try {
            con = dbConnection.dbConnect();
            stmt6 = con.createStatement();
            String query6 = "SELECT COUNT(emp_id) FROM employee;";
            ResultSet rs1 = stmt6.executeQuery(query6);

            if (rs1.next()) {
                int count = rs1.getInt(1);
                //System.out.println("Count: " + count);
                countlable.setText(String.valueOf(count));
                NOTIFICATION1.setText(String.valueOf(count));
            } else {
                System.out.println("No data found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void showMedicament() {
        ObservableList<Medicament> MedicamentList = MedicamentDB.getMedicament();

        this.table.setItems(MedicamentList);
        this.id.setCellValueFactory(new PropertyValueFactory<>("medId"));
        this.fname.setCellValueFactory(new PropertyValueFactory<>("medFname"));
        this.tpno.setCellValueFactory(new PropertyValueFactory<>("medTpno"));
        this.email.setCellValueFactory(new PropertyValueFactory<>("medEmail"));

    }


    //additional button
    @FXML
    void add_button(ActionEvent event){

        if(event.getSource() ==addbtn)
        {
            addAP.setVisible(true);
            updateAp.setVisible(false);
            removeAP.setVisible(false);

        }
        else
        {
            addAP.setVisible(false);
        }

    }

    @FXML
    void insertquery(ActionEvent event){
        String id = idtf.getText();
        String fname = fnametf.getText();
        String lname = lnametf.getText();
        String tp_no = tp_notf.getText();
        String email = emailtf.getText();
        String password = passwordtf.getText();
        String position = "non";

        if (id.isEmpty() || fname.isEmpty() || lname.isEmpty() || tp_no.isEmpty() || password.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields.");
            alert.showAndWait();

        } else if (!isValidEmail(email)) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email address.");
            alert.showAndWait();
        } else {

            try {
                con = dbConnection.dbConnect();
                String query1 = "INSERT INTO employee(emp_id, f_name, l_name, e_tp_no, position, password, e_email, e_image) VALUE(?,?,?,?,?,?,?,?)";
                PreparedStatement stmt1 = con.prepareStatement(query1);
                stmt1.setString(1, id);
                stmt1.setString(2, fname);
                stmt1.setString(3, lname);
                stmt1.setString(4, tp_no);
                stmt1.setString(5, position);
                stmt1.setString(6, password);
                stmt1.setString(7, email);
                stmt1.setString(8, position);

                int rowsAffected = stmt1.executeUpdate();
                if (rowsAffected > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee data added successfully!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("An error occurred while adding employee data.");
                    alert.showAndWait();
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        idtf.setText("");
        fnametf.setText("");
        lnametf.setText("");
        tp_notf.setText("");
        emailtf.setText("");
        passwordtf.setText("");
        count();
        showMedicament();
    }

    public boolean isValidEmail(String email) {
        // Basic email validation using a regular expression
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailPattern);
    }


    //additional button
    @FXML
    void update_button(ActionEvent event){

        if(event.getSource() ==updatebtn)
        {
            updateAp.setVisible(true);
            addAP.setVisible(false);
            removeAP.setVisible(false);

            try {
                addItemsForStaffRemoveCombobox();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            updateAp.setVisible(false);
        }

    }



    @FXML
    void search(ActionEvent event){
        PreparedStatement stmt3;
        String selectedValue = Update_EMP_ID2.getValue();

        try {
            String query3 = "SELECT * FROM employee WHERE emp_id = ?";
            stmt3 = con.prepareStatement(query3);
            stmt3.setString(1, selectedValue);

            ResultSet rs = stmt3.executeQuery();

            while (rs.next()) {
                svalue1 = rs.getString(2);
                svalue2= rs.getString(3);
                svalue3= rs.getString(4);
                svalue4= rs.getString(6);
                svalue5= rs.getString(7);

            }
            updatetextfield1.setText(svalue1);
            updatetextfield2.setText(svalue2);
            updatetextfield3.setText(svalue3);
            updatetextfield4.setText(svalue4);
            updatetextfield5.setText(svalue5);

        } catch (SQLException exx) {
            System.out.println("Error in displaying employee data: " + exx.getMessage());
        }

    }



    @FXML
    void enterupdatequery(ActionEvent event) {

        PreparedStatement stmt4;
        String selectedValue = Update_EMP_ID2.getValue();
        String valuea = updatetextfield1.getText();
        String valueb = updatetextfield2.getText();
        String valuec = updatetextfield3.getText();
        String valued = updatetextfield4.getText();
        String valuee = updatetextfield5.getText();

        if (valuea.isEmpty() || valueb.isEmpty() || valuec.isEmpty() || valued.isEmpty() || valuee.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields.");
            alert.showAndWait();

        } else if (!isValidEmail(valued)) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email address.");
            alert.showAndWait();
        } else {


            try {

                String query4 = "UPDATE employee SET f_name= ?,l_name = ?,e_tp_no= ?,password = ?,e_email= ? WHERE emp_id = ?";
                stmt4 = con.prepareStatement(query4);
                stmt4.setString(1, valuea);
                stmt4.setString(2, valueb);
                stmt4.setString(3, valuec);
                stmt4.setString(4, valuee);
                stmt4.setString(5, valued);
                stmt4.setString(6, selectedValue);
                int rowsAffected = stmt4.executeUpdate();
                if (rowsAffected > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee data updated successfully!");

                    alert.showAndWait();


                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Ooops, there was an error!");

                    alert.showAndWait();

                }

                showMedicament();
            } catch (SQLException exx) {

                System.out.println("Error in displaying all users" + exx.getMessage());
            }

            updatetextfield1.setText("");
            updatetextfield2.setText("");
            updatetextfield3.setText("");
            updatetextfield4.setText("");
            updatetextfield5.setText("");

        }
    }



    //additional button
    @FXML
    void remove_button(ActionEvent event){

        if(event.getSource() ==removebtn)
        {
            removeAP.setVisible(true);
            updateAp.setVisible(false);
            addAP.setVisible(false);
            count();

            try {
                addItemsForStaffRemoveCombobox();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            removeAP.setVisible(true);
        }
        showMedicament();

    }

    @FXML
    void removequery(ActionEvent event){

        PreparedStatement stmt2;
        String selectedValue = Update_EMP_ID.getValue();

        try{

            String query2 = "DELETE FROM employee WHERE emp_id= ?";
            stmt2=con.prepareStatement(query2);
            stmt2.setString(1,selectedValue);
            int rowsAffected=stmt2.executeUpdate();
            if (rowsAffected > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Employee data remove successfully!");

                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();

            }
            count();
            showMedicament();

        }
        catch (SQLException exx){

            System.out.println("Error in displaying all users" + exx.getMessage());
        }

    }

    @FXML
    void Attendencebutton(ActionEvent event) throws IOException {
        if(event.getSource() == attendencebtn)
        {
            attendeceAP.setVisible(true);
            dashStaff.setVisible(false);
            addItemsForStaffRemoveCombobox();
            showMedicamentAttendance();

        }

        else
        {
            attendeceAP.setVisible(false);
        }

    }

    public void showMedicamentAttendance() {
        ObservableList<Empattendance> MedicamentList = MedicamentDB.getMedicament3();

        this.Atable.setItems(MedicamentList);
        this.Aempid.setCellValueFactory(new PropertyValueFactory<>("empId"));
        this.empDate.setCellValueFactory(new PropertyValueFactory<>("empDate"));
    }

    @FXML
    void Enterattendences(ActionEvent event) throws IOException {

        String adate;
        adate= String.valueOf(getdate.getValue());
        PreparedStatement stmtea;
        String selectedValue = UpdateEMP.getValue();

        try{

            String squery ="INSERT INTO attendance (emp_id, date) VALUES (?, ?)";
            stmtea=con.prepareStatement(squery);
            stmtea.setString(1,selectedValue);
            stmtea.setString(2,adate);
            int rowsAffected=stmtea.executeUpdate();
            if (rowsAffected > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("enter attendance successfully!");

                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();

            }

        }
        catch (SQLException exx){

            System.out.println("Error in displaying all users" + exx.getMessage());
        }
        showMedicamentAttendance();
        count2();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////supplier section///////////////////////////////////////////////////////////////////////

    @FXML
    void supplierbutton(ActionEvent event)
    {
        if(event.getSource() == supplierbtn)
        {

            dashAP.setVisible(false);
            dashStaff.setVisible(false);
            supplierAp.setVisible(true);
            attendeceAP.setVisible(false);
            SettingAp.setVisible(false);
            showMedicament1();
            count2();
        }

        else
        {
            supplierAp.setVisible(false);
        }
    }

    public void count2(){

        Statement stmt6;

        try {
            con = dbConnection.dbConnect();
            stmt6 = con.createStatement();
            String query6 = "SELECT COUNT(supplier_id) FROM supplier;";
            ResultSet rs1 = stmt6.executeQuery(query6);

            if (rs1.next()) {
                int count = rs1.getInt(1);
                //System.out.println("Count: " + count);
                countlable1.setText(String.valueOf(count));
                NOTIFICATION3.setText(String.valueOf(count));
            } else {
                System.out.println("No data found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void count3(){

        Statement stmt6;

        try {
            con = dbConnection.dbConnect();
            stmt6 = con.createStatement();
            String query6 = "SELECT COUNT(medicine_id) FROM medicine;";
            ResultSet rs1 = stmt6.executeQuery(query6);

            if (rs1.next()) {
                int count = rs1.getInt(1);
                //System.out.println("Count: " + count);

                NOTIFICATION2.setText(String.valueOf(count));
            } else {
                System.out.println("No data found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void addsupplierbutton(ActionEvent event)
    {
        if(event.getSource() == addsupplierbtn)
        {
            addsuppplierAP.setVisible(true);
            updatesupplierAP.setVisible(false);
            removesupplierAP.setVisible(false);

        }

        else
        {
            addsuppplierAP.setVisible(true);
        }

    }

    @FXML
    void updatesupplierbutten(ActionEvent event) throws IOException {
        if(event.getSource() == updatesupplierbtn)
        {
            addItemsForStaffRemoveCombobox1();
            addsuppplierAP.setVisible(false);
            updatesupplierAP.setVisible(true);
            removesupplierAP.setVisible(false);

        }

        else
        {
            updatesupplierAP.setVisible(false);
        }

    }


    @FXML
    void removesupplierbutten(ActionEvent event) throws IOException {
        if(event.getSource() == removesupplierbtn)
        {
            addItemsForStaffRemoveCombobox1();
            addsuppplierAP.setVisible(false);
            updatesupplierAP.setVisible(false);
            removesupplierAP.setVisible(true);

        }

        else
        {
            removesupplierAP.setVisible(true);
        }

    }



    @FXML
    void insertsupquery(ActionEvent event) {

        PreparedStatement stmts1;
        String id = supidTX.getText();
        String fname = supfnameTX.getText();
        String lname = SlnameTX.getText();
        String tp_no = stpTX.getText();
        String email = semailTX.getText();
        String address = SaddressTX.getText();

        if (id.isEmpty() || fname.isEmpty() || lname.isEmpty() || tp_no.isEmpty() || address.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields.");
            alert.showAndWait();

        } else if (!isValidEmail(email)) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email address.");
            alert.showAndWait();
        } else {

            try {

                con = dbConnection.dbConnect();


                String querys1 = "INSERT INTO supplier (supplier_id, f_name, l_name, s_address, s_tp_no, s_email) VALUES (?, ?, ?, ?, ?, ?)";


                stmts1 = con.prepareStatement(querys1);
                stmts1.setString(1, id);
                stmts1.setString(2, fname);
                stmts1.setString(3, lname);
                stmts1.setString(4, address);
                stmts1.setString(5, tp_no);
                stmts1.setString(6, email);


                int rowsAffected = stmts1.executeUpdate();
                if (rowsAffected > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee data added successfully!");

                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Ooops, there was an error!");

                    alert.showAndWait();

                }


            } catch (SQLException ex) {
                System.out.println("Error in displaying all users" + ex.getMessage());
            }

            supidTX.setText("");
            supfnameTX.setText("");
            SlnameTX.setText("");
            stpTX.setText("");
            semailTX.setText("");
            SaddressTX.setText("");


            showMedicament1();
            count2();

        }
    }


    @FXML
    void search1(ActionEvent event) throws IOException {

        PreparedStatement stmts3;
        String selectedValue = Update_EMP_ID3.getValue();

        try {
            String querys3 = "SELECT * FROM supplier WHERE supplier_id = ?";
            stmts3 = con.prepareStatement(querys3);
            stmts3.setString(1, selectedValue);

            ResultSet rss = stmts3.executeQuery();

            while (rss.next()) {
                svalue6 = rss.getString(2);
                svalue7= rss.getString(3);
                svalue8= rss.getString(4);
                svalue9= rss.getString(5);
                svalue10= rss.getString(6);

            }
            Updatesupname.setText(svalue6);
            Updatesuplname.setText(svalue7);
            Updateaddress.setText(svalue8);
            Updatesuptpno.setText(svalue9);
            Updatesupemail.setText(svalue10);


        } catch (SQLException exx) {
            System.out.println("Error in displaying employee data: " + exx.getMessage());
        }

    }



    @FXML
    void enterupdatequery1(ActionEvent event) {

        PreparedStatement stmts4;
        String selectedValue = Update_EMP_ID3.getValue();
        String valuea = Updatesupname.getText();
        String valueb = Updatesuplname.getText();
        String valuec = Updateaddress.getText();
        String valued = Updatesuptpno.getText();
        String valuee = Updatesupemail.getText();

        if (valuea.isEmpty() || valueb.isEmpty() || valuec.isEmpty() || valued.isEmpty() || valuee.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields.");
            alert.showAndWait();

        } else if (!isValidEmail(valuee)) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email address.");
            alert.showAndWait();
        } else {

            try {

                String query4 = "UPDATE supplier SET f_name = ?, l_name = ?, s_address = ?, s_tp_no = ?, s_email = ? WHERE supplier_id = ? ";
                stmts4 = con.prepareStatement(query4);
                stmts4.setString(1, valuea);
                stmts4.setString(2, valueb);
                stmts4.setString(3, valuec);
                stmts4.setString(4, valued);
                stmts4.setString(5, valuee);
                stmts4.setString(6, selectedValue);
                int rowsAffected = stmts4.executeUpdate();
                if (rowsAffected > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee data updated successfully!");

                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Ooops, there was an error!");

                    alert.showAndWait();

                }

                Updatesupname.setText("");
                Updatesuplname.setText("");
                Updateaddress.setText("");
                Updatesuptpno.setText("");
                Updatesupemail.setText("");
                showMedicament1();
                count2();
            } catch (SQLException exx) {

                System.out.println("Error in displaying all users" + exx.getMessage());
            }

            updatetextfield1.setText("");
            updatetextfield2.setText("");
            updatetextfield3.setText("");
            updatetextfield4.setText("");
            updatetextfield5.setText("");

        }
    }



    @FXML
    void removequery1(ActionEvent event){

        PreparedStatement stmts2;
        String selectedValue = Update_EMP_ID4.getValue();

        try{

            String querys2 = "DELETE FROM supplier WHERE supplier_id= ?";
            stmts2=con.prepareStatement(querys2);
            stmts2.setString(1,selectedValue);
            int rowsAffected=stmts2.executeUpdate();
            if (rowsAffected > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Employee data remove successfully!");

                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();

            }
            count2();
            showMedicament1();

        }
        catch (SQLException exx){

            System.out.println("Error in displaying all users" + exx.getMessage());
        }

    }

    public void showMedicament1() {
        ObservableList<Suppliertable> MedicamentList = MedicamentDB.getMedicament1();

        this.table1.setItems(MedicamentList);
        this.id1.setCellValueFactory(new PropertyValueFactory<>("supId"));
        this.fname1.setCellValueFactory(new PropertyValueFactory<>("supFname"));
        this.tpno1.setCellValueFactory(new PropertyValueFactory<>("supTpno"));
        this.address.setCellValueFactory(new PropertyValueFactory<>("supAddress"));


    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////admin//////////////////////////////////////////////////////////////////


    @FXML
    public void Setting(ActionEvent event) throws IOException {

        if(event.getSource() == settingstbtn)
        {
            AaminsettingCombobox2();
            dashAP.setVisible(false);
            dashStaff.setVisible(false);
            supplierAp.setVisible(false);
            attendeceAP.setVisible(false);
            SettingAp.setVisible(true);


        }

        else
        {
            SettingAp.setVisible(false);
        }

    }

    @FXML
    void search3(ActionEvent event) throws IOException {

        PreparedStatement stmta3;
        String selectedValue = Update_EMP_ID5.getValue();

        try {
            String querys3 = "SELECT * FROM admin WHERE admin_id = ?";
            stmta3 = con.prepareStatement(querys3);
            stmta3.setString(1, selectedValue);

            ResultSet rss = stmta3.executeQuery();

            while (rss.next()) {
                svalue11 = rss.getString(2);
                svalue12= rss.getString(3);
                svalue13= rss.getString(4);


            }
            ADMINFNAME.setText(svalue11);
            ADMINLNAME.setText(svalue12);
            ADMINPASSWORD.setText(svalue13);



        } catch (SQLException exx) {
            System.out.println("Error in displaying employee data: " + exx.getMessage());
        }

    }
    @FXML
    public void SETTINGADMIN(ActionEvent event){

        PreparedStatement stmta4;
        String selectedValue = Update_EMP_ID5.getValue();
        String valuea = ADMINFNAME.getText();
        String valueb = ADMINLNAME.getText();
        String valuec = ADMINPASSWORD.getText();

        System.out.println("dsfdsfsdfdfsdfsdfsdfsdfd");



            try {

                String query4 = "UPDATE `admin` SET `f_name` = ?, `l_name` = ?, `password` = ? WHERE `admin_id` = ?";
                stmta4 = con.prepareStatement(query4);
                stmta4.setString(1, valuea);
                stmta4.setString(2, valueb);
                stmta4.setString(3, valuec);
                stmta4.setString(4, selectedValue);

                int rowsAffected = stmta4.executeUpdate();
                if (rowsAffected > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Admin data updated successfully!");

                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Ooops, there was an error!");

                    alert.showAndWait();

                }


            } catch (SQLException exx) {

                System.out.println("Error in displaying all users" + exx.getMessage());
            }


    }








   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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


    ////////////////////////////////////////////////////////////////
    // ResultSets


    public void addItemsForStaffRemoveCombobox() throws IOException {

        //Connection con;
        Statement stmt;

        try {
//
            con= dbConnection.dbConnect();
            stmt = con.createStatement();

            String query = "SELECT * FROM employee";

            ResultSet rs1 = stmt.executeQuery(query);

            ObservableList<String> combo = FXCollections.observableArrayList();

            while (rs1.next()) {
                combo.add(rs1.getString("emp_id"));
            }

            Update_EMP_ID.setItems(combo);
            Update_EMP_ID2.setItems(combo);
            UpdateEMP.setItems(combo);
            Update_EMP_ID3.setItems(combo);

        } catch (SQLException ex) {
            System.out.println("Error in displaying all users" + ex.getMessage());
        }

    }


    public void addItemsForStaffRemoveCombobox1() throws IOException {

        //Connection con;
        Statement stmt;

        try {

            con= dbConnection.dbConnect();
            stmt = con.createStatement();

            String query = "SELECT * FROM supplier";

            ResultSet rs1 = stmt.executeQuery(query);

            ObservableList<String> combo = FXCollections.observableArrayList();

            while (rs1.next()) {
                combo.add(rs1.getString("supplier_id"));
            }

            Update_EMP_ID3.setItems(combo);
            Update_EMP_ID4.setItems(combo);


        } catch (SQLException ex) {
            System.out.println("Error in displaying all users" + ex.getMessage());
        }

    }

    public void AaminsettingCombobox2() throws IOException {

        //Connection con;
        Statement stmt;

        try {

            con= dbConnection.dbConnect();
            stmt = con.createStatement();

            String query = "SELECT * FROM admin";

            ResultSet rs1 = stmt.executeQuery(query);

            ObservableList<String> combo = FXCollections.observableArrayList();

            while (rs1.next()) {
                combo.add(rs1.getString("admin_id"));
            }

            Update_EMP_ID5.setItems(combo);



        } catch (SQLException ex) {
            System.out.println("Error in displaying all users" + ex.getMessage());
        }

    }


   /* private void dashBoardPieChart() {
        ObservableList<Data> data = FXCollections.observableArrayList();

       /* try {
            // Connect to the database
            con= dbConnection.dbConnect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT medicine_name value FROM your_table");

            while (resultSet.next()) {
                String category = resultSet.getString("category");
                double value = resultSet.getDouble("value");
                data.add(new PieChart.Data(category, value));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;*/
       /* try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT\n" +
                    "    M.medicine_id,\n" +
                    "    COALESCE(SUM(S.quantity), 0) - COALESCE(SUM(SL.quantity), 0) AS current_quantity\n" +
                    "FROM\n" +
                    "    stock AS S\n" +
                    "    JOIN medicine AS M ON S.medicine_id = M.medicine_id\n" +
                    "LEFT JOIN sale AS SL ON S.medicine_id = SL.medicine_id\n" +
                    "GROUP BY\n" +
                    "    M.medicine_id;\n");

            while (resultSet.next()) {
                String medicineId = resultSet.getString("medicine_id");
                int currentQuantity = resultSet.getInt("current_quantity");
                AdminDashPirChart.addEventFilter(new Data(medicineId, currentQuantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PieChart pieChart = new PieChart((ObservableList<Data>) AdminDashPirChart);
        pieChart.setTitle("Medicine Quantities");

        Scene scene = new Scene(pieChart, 800, 600);

        stage.setScene(scene);
        stage.show();

    }

   */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMedicament();
        count();
        count2();
        count3();
    }
}

