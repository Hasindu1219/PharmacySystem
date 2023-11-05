package com.pharmacyshopmanagementsystem.Employee;

import com.pharmacyshopmanagementsystem.DBconnection.dbConnection;
import com.pharmacyshopmanagementsystem.user.UserDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class EmployeeControlPanel implements Initializable {

    @FXML
    private AnchorPane Staff_Dashboard_AP;

    @FXML
    private Label attendance_count;

    @FXML
    private ImageView btn_dashboard11;

    @FXML
    private ImageView btn_dashboard111;

    @FXML
    private ImageView btn_dashboard1111;

    @FXML
    private ImageView e_btn_dashboard;

    @FXML
    private Button e_customerbtn;

    @FXML
    private AnchorPane e_dashAP;

    @FXML
    private AnchorPane e_dashStaff;

    @FXML
    private Button e_dashbtn;

    @FXML
    private Label e_id_label;

    @FXML
    private Pane e_inner_pane;

    @FXML
    private Button e_logoutbtn;

    @FXML
    private Button e_medicinebtn;

    @FXML
    private Label e_name_label;

    @FXML
    private Button e_orderbtn;

    @FXML
    private Button e_settingstbtn;

    @FXML
    private AnchorPane e_side_slider;

    @FXML
    private AnchorPane Customer_Dashboard_AP;


    @FXML
    private Label medicine_count;

    @FXML
    private Label user_count;
    @FXML
    private Button c_create_btn;

    @FXML
    private Button c_delete_btn;

    @FXML
    private Button c_update_btn;
    @FXML
    private AnchorPane c_create_AP;
    @FXML
    private TextField cus_address;

    @FXML
    private DatePicker cus_dob;

    @FXML
    private TextField cus_fname;

    @FXML
    private TextField cus_id;

    @FXML
    private TextField cus_lname;

    @FXML
    private TextField cus_pno;

    @FXML
    private Button cus_create_btn;

    @FXML
    private AnchorPane c_update_AP;

    @FXML
    private ComboBox<String> u_AP_dropdown;

    @FXML
    private Button u_AP_search_btn;
    @FXML
    private TextField UPA;

    @FXML
    private TextField UPFN;

    @FXML
    private TextField UPLN;

    @FXML
    private TextField UPPN;

    @FXML
    private Button UPUB;
    @FXML
    private Button c_del_btn;

    @FXML
    private AnchorPane c_delete_AP;
    @FXML
    private ComboBox<String> cDelDropDown;

    @FXML
    private TableColumn<?, ?> CA;

    @FXML
    private TableColumn<?, ?> CDOB;

    @FXML
    private TableColumn<?, ?> CFN;

    @FXML
    private TableColumn<?, ?> CID;

    @FXML
    private TableColumn<?, ?> CLN;

    @FXML
    private TableColumn<?, ?> CPN;

    @FXML
    private TableView<Medicament> Customer_Table;

    @FXML
    private AnchorPane Order_Dashboard_AP;

    @FXML
    private ComboBox<String> combo1_medid;

    @FXML
    private TableColumn<?, ?> MD;

    @FXML
    private TableColumn<?, ?> MID;

    @FXML
    private TableColumn<?, ?> MN;

    @FXML
    private TableColumn<?, ?> MQ;

    @FXML
    private TableColumn<?, ?> MUP;

    @FXML
    private Label medi_name;

    @FXML
    private TextField medi_qun;

    @FXML
    private TableView<MedicineTableAdd> medicine_details_table;
    @FXML
    private ComboBox<String> combo_cusid;





    @FXML
    private BarChart<?, ?> meddatachart;
    Connection con;



    Stage stage;
    Scene scene;

    @FXML
    public void lb()
    {
        e_id_label.setText("Id : "+UserDetails.getUserID());
        e_name_label.setText("Name : "+UserDetails.getUserName());
    }


    public void logout(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();

        if(option.get().equals(ButtonType.OK))
        {
            e_logoutbtn.getScene().getWindow().hide();

//                Parent root = FXMLLoader.load(getClass().getResource("LoginContainer.fxml"));
//                Stage stage = new Stage();
//                Scene scene = new Scene(root);
//
//                stage.setScene(scene);
//                stage.show();
//                Parent root = FXMLLoader.load(getClass().getResource("LoginContainer.fxml"));
//                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginContainer.fxml")));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root, 1200,700);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();

        }
    }

    //Dashboard Navigations
    @FXML
    void click(ActionEvent event){

        if(event.getSource() ==e_dashbtn)
        {
            Staff_Dashboard_AP.setVisible(true);
            Customer_Dashboard_AP.setVisible(false);
            Order_Dashboard_AP.setVisible(false);

        }
        if(event.getSource() ==e_customerbtn)
        {
            Order_Dashboard_AP.setVisible(false);
            Customer_Dashboard_AP.setVisible(true);
            Staff_Dashboard_AP.setVisible(false);
        }
        if(event.getSource() ==e_orderbtn)
        {
            Order_Dashboard_AP.setVisible(true);
            Staff_Dashboard_AP.setVisible(false);
            Customer_Dashboard_AP.setVisible(false);
        }
    }











    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //Dashboard Management
    public void dashboard_loadings()
    {
        dashboard_cards_loading();
        medDataChart();
    }

    public void dashboard_cards_loading()
    {
        //Add medical count

        try {
            Statement stmt;
            con = dbConnection.dbConnect();
            stmt = con.createStatement();
            String query = "SELECT COUNT(*) AS count  FROM medicine";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            medicine_count.setText(String.valueOf(rs.getInt("count")));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //Add users count

        try {
            Statement stmt;
            con = dbConnection.dbConnect();
            stmt = con.createStatement();
            String query = "SELECT COUNT(*) AS count  FROM customer";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            user_count.setText(String.valueOf(rs.getInt("count")));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //Add attendance count

        try {
            Statement stmt = null;

            String query = "SELECT COUNT(*) AS count FROM attendance WHERE status = 'true' AND emp_id = '" + UserDetails.getUserID() + "'";
            String query1 = "SELECT COUNT(*) AS count  FROM attendance WHERE emp_id = '" + UserDetails.getUserID() + "'";

            stmt = con.createStatement();

            int count1 = 0;
            int count2 = 0;


            ResultSet rs =  stmt.executeQuery(query);
            rs.next();
            count1 = rs.getInt("count");

            ResultSet rs1 = stmt.executeQuery(query1);
            rs1.next();
            count2 = rs1.getInt("count");
            

            attendance_count.setText(count1 + "/" + count2);
        } catch (SQLException e) {
            System.out.println(e+e.getMessage());
            throw new RuntimeException(e);


        }

    }

    public void medDataChart()
    {

        String query = "SELECT m.medicine_name, s.total_quantity FROM medicine m JOIN (SELECT medicine_id, SUM(quantity) as total_quantity FROM stock GROUP BY medicine_id) s ON m.medicine_id = s.medicine_id;";
        Statement stmt = null;

        meddatachart.getData().clear();

        try {
            XYChart.Series ChartData = new XYChart.Series();

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                boolean add = ChartData.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
            }

            meddatachart.getData().add(ChartData);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //Customer Management
    @FXML
    void c_ManagementClick(ActionEvent event){

        if(event.getSource() ==c_create_btn)
        {
            c_create_AP.setVisible(true);
            c_update_AP.setVisible(false);
            c_delete_AP.setVisible(false);

        }
        else if(event.getSource() ==c_update_btn)
        {
            c_update_AP.setVisible(true);
            c_create_AP.setVisible(false);
            c_delete_AP.setVisible(false);
            cIDDropdownLoader();
        }
        else if(event.getSource() ==c_delete_btn)
        {
            c_create_AP.setVisible(false);
            c_delete_AP.setVisible(true);
            c_update_AP.setVisible(false);
            cIDDropdownLoader();
        }

    }

    void cIDDropdownLoader(){
        try {
            Statement stmt;
            con = dbConnection.dbConnect();
            stmt = con.createStatement();
            ObservableList<String> listacombo= FXCollections.observableArrayList();
            String query = "SELECT customer_id   FROM customer";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                listacombo.add(rs.getString("customer_id"));
            }
            u_AP_dropdown.setItems(listacombo);
            cDelDropDown.setItems(listacombo);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e.getMessage());
        }
    }

//    void cIDDropdownLoader1(){
//        try {
//
//            Statement stmt;
//            con = dbConnection.dbConnect();
//            stmt = con.createStatement();
//            ObservableList<String> listacombo= FXCollections.observableArrayList();
//            String query = "SELECT customer_id   FROM customer";
//            ResultSet rs = stmt.executeQuery(query);
//
//            while( rs.next())
//            {
//                listacombo.add(rs.getString("customer_id"));
//            }
//            cDelDropDown.setItems(listacombo);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @FXML
    void cUpdateDetailsLoader(){
        try {
            String c_id = u_AP_dropdown.getValue();

            Statement stmt;
            con = dbConnection.dbConnect();
            stmt = con.createStatement();

            String query = "SELECT *  FROM customer where customer_id='"+c_id+"'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) { // Check if there are results in the ResultSet
                UPFN.setText(rs.getString("f_name"));
                UPLN.setText(rs.getString("l_name"));
                UPA.setText(rs.getString("c_address"));
                UPPN.setText(rs.getString("c_tp_no"));
            } else {
                // Handle the case when no matching customer is found
                // You can clear the text fields or display an error message
                UPFN.clear();
                UPLN.clear();
                UPA.clear();
                UPPN.clear();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cUpdateDetails(){
        try {
            String c_id = u_AP_dropdown.getValue();

            con = dbConnection.dbConnect();

            PreparedStatement ps = con.prepareStatement("UPDATE customer SET f_name=?, l_name=?, c_address=?, c_tp_no=? WHERE customer_id=?");

            ps.setString(1, UPFN.getText());
            ps.setString(2, UPLN.getText());
            ps.setString(3, UPA.getText());
            ps.setString(4, UPPN.getText());
            ps.setString(5, c_id);

            ps.executeUpdate();
            System.out.println("Customer data Updated successfully.");

            UPFN.clear();
            UPLN.clear();
            UPA.clear();
            UPPN.clear();

            showCustomers();
            dashboard_loadings();

            } catch (SQLException ex)
        {
                System.out.println("Error in Updating");
                UPFN.clear();
                UPLN.clear();
                UPA.clear();
                UPPN.clear();
                throw new RuntimeException(ex);
        }
    }

    @FXML
    void cDeleteDetails(){
        try {
            String c_id = cDelDropDown.getValue();

            con = dbConnection.dbConnect();

            PreparedStatement ps = con.prepareStatement("DELETE FROM customer  WHERE customer_id=?");

            ps.setString(1, c_id);

            ps.executeUpdate();
            System.out.println("Customer data Deleted successfully.");

            cIDDropdownLoader();

            showCustomers();
            dashboard_loadings();


        } catch (SQLException ex)
        {
            System.out.println("Error in Deletion");

            throw new RuntimeException(ex);
        }
    }



        @FXML
    void customerCreate() {
        String id;
        String fName;
        String lName;
        String address;
        String phoneNumber;

        try {
            con = dbConnection.dbConnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        id = cus_id.getText();
        fName = cus_fname.getText();
        lName = cus_lname.getText();
        address = cus_address.getText();
        phoneNumber = cus_pno.getText();

        Date selectedValue = Date.valueOf(cus_dob.getValue());
        System.out.println("Selected Date: " + selectedValue);



        if (selectedValue != null) {

            try (
                 PreparedStatement ps = con.prepareStatement("INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?)")) {

                ps.setString(1, id);
                ps.setString(2, fName);
                ps.setString(3, lName);
                ps.setString(4, String.valueOf(selectedValue));
                ps.setString(5, address);
                ps.setString(6, phoneNumber);

                ps.executeUpdate();
                System.out.println("Customer data inserted successfully.");

                cus_id.setText("");
                cus_fname.setText("");
                cus_lname.setText("");
                cus_address.setText("");
                cus_pno.setText("");
                cus_dob.setValue(null);

                showCustomers();
                dashboard_loadings();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Please select a valid date.");
        }
    }

    public void showCustomers() {
        ObservableList<Medicament> MedicamentList = MedicamentDB.getCustomerDetails();

        this.Customer_Table.setItems(MedicamentList);
        this.CID.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        this.CFN.setCellValueFactory(new PropertyValueFactory<>("cusFname"));
        this.CLN.setCellValueFactory(new PropertyValueFactory<>("cusLname"));
        this.CDOB.setCellValueFactory(new PropertyValueFactory<>("cusDOB"));
        this.CA.setCellValueFactory(new PropertyValueFactory<>("cusAddress"));
        this.CPN.setCellValueFactory(new PropertyValueFactory<>("custpno"));

    }





    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //Order Management

    public void showMedicine() {
        ObservableList<MedicineTableAdd> Medicine = MedicamentDB.getMedicineDetails();

        this.medicine_details_table.setItems(Medicine);
        this.MID.setCellValueFactory(new PropertyValueFactory<>("med_Id"));
        this.MN.setCellValueFactory(new PropertyValueFactory<>("med_Name"));
        this.MD.setCellValueFactory(new PropertyValueFactory<>("med_Sid"));
        this.MQ.setCellValueFactory(new PropertyValueFactory<>("med_Desciption"));
        this.MUP.setCellValueFactory(new PropertyValueFactory<>("med_Uprice"));

    }

    void medicineIDLoader(){
        try {
            Statement stmt;
            con = dbConnection.dbConnect();
            stmt = con.createStatement();
            ObservableList<String> listacombo= FXCollections.observableArrayList();
            String query = "SELECT medicine_id   FROM medicine";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                listacombo.add(rs.getString("medicine_id"));
            }
            combo1_medid.setItems(listacombo);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e.getMessage());
        }
    }


    @FXML
    void medicineNameLoader(){
        try {
            Statement stmt;
            con = dbConnection.dbConnect();
            stmt = con.createStatement();
            String mid = combo1_medid.getSelectionModel().getSelectedItem();

            String query = "SELECT medicine_name FROM medicine where medicine_id = '"+mid+"'";
            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            medi_name.setText(rs.getString("medicine_name"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e.getMessage());
        }
    }

    @FXML
    void cusIDLoader(){
        try {
            Statement stmt;
            con = dbConnection.dbConnect();
            stmt = con.createStatement();

            ObservableList<String> listacombo= FXCollections.observableArrayList();

            String query = "SELECT customer_id FROM customer ";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                listacombo.add(rs.getString("customer_id"));
            }
            combo_cusid.setItems(listacombo);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e.getMessage());
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lb();
        dashboard_loadings();
        showCustomers();
        showMedicine();
        cIDDropdownLoader();
        medicineIDLoader();
        cusIDLoader();

    }
}
