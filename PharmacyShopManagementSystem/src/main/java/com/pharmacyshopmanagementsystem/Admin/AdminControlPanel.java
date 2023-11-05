package com.pharmacyshopmanagementsystem.Admin;

import com.pharmacyshopmanagementsystem.DBconnection.dbConnection;
import com.pharmacyshopmanagementsystem.customer.Medicament;
import com.pharmacyshopmanagementsystem.customer.MedicamentSearchTable;
import com.pharmacyshopmanagementsystem.customer.MedicamentTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.PreparedStatement;


public class AdminControlPanel {
    Connection con;
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


    //Customer Anchor pane//////////////////////////////////////////////////////////////
    @FXML
    private TextField searchTextField;
    @FXML
    private Button searchCustomerBtn;
    @FXML
    private ComboBox<String> searchOptionCB;
    @FXML
    private DatePicker dateOfBirthPicker;
    @FXML
    private TableView<Medicament> tableView;
    @FXML
    private TableColumn<Medicament,String> tableCID;
    @FXML
    private TableColumn<Medicament,String> tableFName;
    @FXML
    private TableColumn<Medicament,String> tableLName;
    @FXML
    private TableColumn<Medicament,String> tableDOB;
    @FXML
    private TableColumn<Medicament,String> tableAddress;
    @FXML
    private TableColumn<Medicament,String> tableTP;
    @FXML
    private AnchorPane customerAP;
    @FXML
    private Button customerViewBtn;
    @FXML
    private Button customerAddBtn;
    @FXML
    private Button customerUpdateBtn;
    @FXML
    private Button customerDeleteBtn;
    @FXML
    private AnchorPane customerTableAP;

    @FXML
    private AnchorPane customerAddAP;
    @FXML
    private Button customerResetBtn1;
    @FXML
    private Button customerAddAddbtn;


    @FXML
    private AnchorPane customerDeleteAP;
    @FXML
    private Button customerDeleteDeletebtn;
    @FXML
    private Button customerResetBtn2;


    @FXML
    private AnchorPane customerUpdateAP;
    @FXML
    private Button customerUpdateUpdatebtn;
    @FXML
    private Button customerUpdateResetBtn3;
    @FXML
    private TextField cidTF;
    @FXML
    private TextField cidTF1;
    @FXML
    private TextField cidTF2;
    @FXML
    private TextField fnameTF;
    @FXML
    private TextField lNameTF;
    @FXML
    private TextField dOBTF;
    @FXML
    private TextField tpTF;
    @FXML
    private TextField tpTF1;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField addressTF1;

    ////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void dashbutton(ActionEvent event)
    {
        if(event.getSource() == dashbtn)
        {
            dashAP.setVisible(true);
            dashStaff.setVisible(false);

        }

        else
        {
            dashAP.setVisible(false);
        }

    }

    //staff section
    @FXML
    void staffbutton(ActionEvent event)
    {
        if(event.getSource() ==staffbtn)
        {
             dashStaff.setVisible(true);
             dashAP.setVisible(false);


        }

        else
        {
            dashAP.setVisible(false);
        }

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
    //additional button
    @FXML
    void update_button(ActionEvent event){

        if(event.getSource() ==updatebtn)
        {
            updateAp.setVisible(true);
            addAP.setVisible(false);
            removeAP.setVisible(false);

        }
        else
        {
            updateAp.setVisible(false);
        }

    }
            updatetextfield5.setText(svalue5);
    //additional button
    @FXML
    void remove_button(ActionEvent event){

        if(event.getSource() ==removebtn)
        {
            removeAP.setVisible(true);
            updateAp.setVisible(false);
            addAP.setVisible(false);

        }
        else
        {
            removeAP.setVisible(true);
        }

    }
    //Customer Anchor pane functions///////////////////////////////////////////////////////////////////////
    @FXML
    void customerButton(ActionEvent event){
        if(event.getSource() == customerbtn)
        {
            dashAP.setVisible(false);

            dashStaff.setVisible(false);

            customerAP.setVisible(true);

            customerTableAP.setVisible(true);
            customerAddAP.setVisible(false);
            customerUpdateAP.setVisible(false);
            customerDeleteAP.setVisible(false);
            showMedicament();

            searchOptionCB.getItems().addAll("Customer ID","First Name","Last Name");
            searchOptionCB.setValue("Customer ID");

        }
        else
        {
            customerAP.setVisible(false);
        }
    }
    //search button click
    @FXML
    void customerSearch(ActionEvent event) {
        if (event.getSource() == searchCustomerBtn){

            String searchText=searchTextField.getText();

            if(searchText.isBlank()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please fill search field!");

                alert.showAndWait();
            }
            else{

                if("First Name"==searchOptionCB.getValue()){
                    showSearchCustomersByFirstName(searchText);
                    System.out.println(searchOptionCB.getValue());
                }else if("Last Name"==searchOptionCB.getValue()){
                    showSearchCustomersByLastName(searchText);
                    System.out.println(searchOptionCB.getValue());
                }else{
                    showSearchCustomersById(searchText);
                    System.out.println(searchOptionCB.getValue());
                }
            }
        }
    }

    public void showSearchCustomersById(String customerid){
        ObservableList<Medicament> MedicamentList = MedicamentSearchTable.getMedicamentByID(customerid);

        this.tableView.setItems(MedicamentList);
        this.tableCID.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        this.tableFName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        this.tableLName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        this.tableDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        this.tableAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.tableTP.setCellValueFactory(new PropertyValueFactory<>("custpno"));
    }

    public void showSearchCustomersByFirstName(String firstName){
        ObservableList<Medicament> MedicamentList = MedicamentSearchTable.getMedicamentByFirstName(firstName);

        this.tableView.setItems(MedicamentList);
        this.tableCID.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        this.tableFName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        this.tableLName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        this.tableDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        this.tableAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.tableTP.setCellValueFactory(new PropertyValueFactory<>("custpno"));
    }
    public void showSearchCustomersByLastName(String lastName){
        ObservableList<Medicament> MedicamentList = MedicamentSearchTable.getMedicamentByLastName(lastName);

        this.tableView.setItems(MedicamentList);
        this.tableCID.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        this.tableFName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        this.tableLName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        this.tableDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        this.tableAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.tableTP.setCellValueFactory(new PropertyValueFactory<>("custpno"));
    }

    //view button click
    @FXML
    void viewCustomerButton(ActionEvent event){
        if(event.getSource() == customerViewBtn)
        {
            customerTableAP.setVisible(true);
            customerAddAP.setVisible(false);
            customerUpdateAP.setVisible(false);
            customerDeleteAP.setVisible(false);
            showMedicament();
        }
        else
        {
            customerTableAP.setVisible(false);
        }
    }
    public void showMedicament() {
        ObservableList<Medicament> MedicamentList = MedicamentTable.getMedicament();

        this.tableView.setItems(MedicamentList);
        this.tableCID.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        this.tableFName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        this.tableLName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        this.tableDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        this.tableAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.tableTP.setCellValueFactory(new PropertyValueFactory<>("custpno"));

    }

    //Add button click
    @FXML
    void addCustomerButton(ActionEvent event){
        if(event.getSource() == customerAddBtn)
        {
            customerAddAP.setVisible(true);
            customerTableAP.setVisible(false);
            customerUpdateAP.setVisible(false);
            customerDeleteAP.setVisible(false);
        }
        else
        {
            customerAddAP.setVisible(false);
        }
    }

    //Update button click
    @FXML
    void updateCustomerButton(ActionEvent event){
        if(event.getSource() == customerUpdateBtn)
        {
            customerUpdateAP.setVisible(true);
            customerAddAP.setVisible(false);
            customerTableAP.setVisible(false);
            customerDeleteAP.setVisible(false);
        }
        else
        {
            customerUpdateAP.setVisible(false);
        }
    }

    //Delete button click
    @FXML
    void deleteCustomerButton(ActionEvent event){
        if(event.getSource() == customerDeleteBtn)
        {
            customerDeleteAP.setVisible(true);
            customerUpdateAP.setVisible(false);
            customerAddAP.setVisible(false);
            customerTableAP.setVisible(false);
        }
        else
        {
            customerDeleteAP.setVisible(false);
        }
    }

    @FXML
    void addRecord(ActionEvent event){
        if(event.getSource() == customerAddAddbtn)
        {
            PreparedStatement ps;
            String cid=cidTF.getText();
            String fName=fnameTF.getText();
            String lName=lNameTF.getText();
            String address= addressTF.getText();
            String tpNo=tpTF.getText();

            String dob = String.valueOf(dateOfBirthPicker.getValue());

            if(cid.isBlank() || fName.isBlank() || dob.isBlank() || address.isBlank() || tpNo.isBlank()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all required fields!");

                alert.showAndWait();
            }
            else{
                try {

                    con= dbConnection.dbConnect();

                    String query ="INSERT INTO customer(customer_id,f_name,l_name,DOB,c_address,c_tp_no) VALUE(?,?,?,?,?,?)";

                    ps=con.prepareStatement(query);

                    ps.setString(1,cid);
                    ps.setString(2,fName);
                    ps.setString(3,lName);
                    ps.setString(4,dob);
                    ps.setString(5,address);
                    ps.setString(6,tpNo);

                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Customer added successfully!");

                        alert.showAndWait();

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("Look, an Error Dialog");
                        alert.setContentText("Ooops, there was an error!");

                        alert.showAndWait();

                    }

                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText(ex.getMessage());

                    alert.showAndWait();
                }
            }

        }
    }
    @FXML
    void resetButton1(ActionEvent event){
        if(event.getSource() == customerResetBtn1){
            cidTF.setText("");
            fnameTF.setText("");
            lNameTF.setText("");
            dOBTF.setText("");
            addressTF.setText("");
            tpTF.setText("");
        }
    }

    @FXML
    void updateRecord(ActionEvent event){
        if(event.getSource() == customerUpdateUpdatebtn)
        {
            String cid = cidTF1.getText();
            String tpNo = tpTF1.getText();
            String address = addressTF1.getText();

            if(!cid.isBlank() && (tpNo.isBlank() || address.isBlank())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Customer ID field is Required, one of the other is mandatory");

                alert.showAndWait();
            }
            else {
                PreparedStatement ps;
                try {
                    con = dbConnection.dbConnect();

                    String query = "UPDATE customer SET c_address=? ,c_tp_no=? WHERE customer_id=?";

                    ps = con.prepareStatement(query);

                    ps.setString(3, cid);
                    ps.setString(2, tpNo);
                    ps.setString(1, address);

                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Customer Updated successfully!");

                        alert.showAndWait();

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("Look, an Error Dialog");
                        alert.setContentText("Ooops, there was an error!");

                        alert.showAndWait();

                    }
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText(ex.getMessage());

                    alert.showAndWait();
                }
            }
        }
    }
    @FXML
    void resetButton3(ActionEvent event){
        if(event.getSource() == customerUpdateResetBtn3){
            cidTF1.setText("");
            addressTF1.setText("");
            tpTF1.setText("");
        }
    }
    @FXML
    void deleteRecord(ActionEvent event){
        if(event.getSource() == customerDeleteDeletebtn)
        {
            String cid=cidTF2.getText();

            if(cid.isBlank()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Customer ID field is Required!");

                alert.showAndWait();
            }
            else {
                PreparedStatement ps;
                try {
                    con = dbConnection.dbConnect();

                    String query = "DELETE FROM customer WHERE customer_id=?";

                    ps = con.prepareStatement(query);

                    ps.setString(1, cid);

                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Customer Deleted successfully!");

                        alert.showAndWait();

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("Look, an Error Dialog");
                        alert.setContentText("Ooops, there was an error!");

                        alert.showAndWait();

                    }
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText(ex.getMessage());

                    alert.showAndWait();
                }
            }
        }
    }
    @FXML
    void resetButton2(ActionEvent event){
        if(event.getSource() == customerResetBtn2){
            cidTF2.setText("");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

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

