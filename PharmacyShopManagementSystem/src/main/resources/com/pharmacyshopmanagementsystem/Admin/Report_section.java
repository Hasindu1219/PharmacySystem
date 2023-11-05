package com.pharmacyshopmanagementsystem.Admin;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class Report_section extends Application {
    @FXML
    private Pane chart_pannel;

    @FXML
    private ComboBox<String> report_type;

    @FXML
    private ComboBox<String> time_limit;

    @FXML
    private LineChart<String, Number> line_chart;
    @FXML
    private CategoryAxis xaxis;

    @FXML
    private NumberAxis yaxis;

    @FXML
    private Label Amount;

    @FXML
    private Label sales;
    @FXML
    private Label date;

    @FXML
    private Label title;
Connection con=new Db_connect().DBConet();
    @FXML
    void view_report() {
        Set<String> category=new HashSet<>();
        String type=report_type.getValue();
        String limit=time_limit.getValue();
        System.out.println(limit);
        System.out.println(type);
        date.setText(String.valueOf(LocalDate.now()));

        if(type=="Sales Report" && limit=="Daily"){
            line_chart.getData().clear();
            System.out.println("sale and daily");
            title.setText("");
            title.setText("Sales Report : Day");
            line_chart.setTitle("");
            line_chart.setTitle("Sales of The Day :"+LocalDate.now());
            XYChart.Series<String,Number> series=new XYChart.Series<>();
          /*  series.getData().add(new XYChart.Data<>("cat1",2));
            series.getData().add(new XYChart.Data<>("cat2",4));
            series.getData().add(new XYChart.Data<>("cat3",1));
            series.getData().add(new XYChart.Data<>("cat4",6));*/

            series.setName("Sales Data");
            try{
            PreparedStatement preparedStatement = con.prepareStatement("select m.medicine_name,s.quantity,m.unit_price from medicine m left join sale s on m.medicine_id=s.medicine_id where s.sale_date=?");
            preparedStatement.setString(1, String.valueOf(LocalDate.now()));
            ResultSet re=preparedStatement.executeQuery();


          while(re.next()){
                double unit_price=re.getDouble("unit_price");
                int quntity=re.getInt("quantity");
                Double Total=unit_price*quntity;
                sales.setText("Total Sales");
                Amount.setText(String.valueOf(Total));

                series.getData().add(new XYChart.Data<>(re.getString("medicine_name"),re.getInt("quantity")));
              line_chart.getData().add(series);
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }
        if(type=="Sales Report" && limit=="Monthly"){
            line_chart.getData().clear();
            System.out.println("sale and monthly");
            title.setText("");
            title.setText("Sales Report : Month");
            line_chart.setTitle("");
            line_chart.setTitle("Sales of The Month :"+LocalDate.now().getYear()+" - "+LocalDate.now().getMonth());
            try{
                PreparedStatement preparedStatement = con.prepareStatement("select m.medicine_name,s.quantity,m.unit_price from medicine m left join sale s on m.medicine_id=s.medicine_id where year(s.sale_date)=? and month(s.sale_date)=?");
                preparedStatement.setString(1, String.valueOf(LocalDate.now().getYear()));
                preparedStatement.setString(2, String.valueOf(LocalDate.now().getMonth()));
                ResultSet re=preparedStatement.executeQuery();
                XYChart.Series<String,Number> series=new XYChart.Series<>();
                while (re.next()){
                    double unit_price=re.getDouble("unit_price");
                    int quntity=re.getInt("quantity");
                    Double Total=unit_price*quntity;
                    sales.setText("Total Sales");
                    Amount.setText(String.valueOf(Total));


                    series.getData().add(new XYChart.Data<>(re.getString("medicine_name"),re.getInt("quantity")));
                    
                }
                line_chart.getData().add(series);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        if(type=="Sales Report" && limit=="Yearly"){
            line_chart.getData().clear();
            System.out.println("sale and year");
            title.setText("");
            xaxis.setViewOrder(2);
            title.setText("Sales Report : Year");
            line_chart.setTitle("");
            line_chart.setTitle("Sales of The Year :"+LocalDate.now().getYear());

            try{
                PreparedStatement preparedStatement = con.prepareStatement("select m.medicine_name,s.quantity,m.unit_price from medicine m left join sale s on m.medicine_id=s.medicine_id where year(s.sale_date)=?");
                preparedStatement.setString(1, String.valueOf(LocalDate.now().getYear()));
                ResultSet re=preparedStatement.executeQuery();
                double Total=0;
                XYChart.Series<String,Number> series=new XYChart.Series<>();
                while(re.next()){
                    category.add(re.getString("medicine_name"));
                    List<String> cate= new ArrayList<>(category);
                    Collections.sort(cate);
                    xaxis.setCategories(FXCollections.observableArrayList(cate));
                    String med=re.getString("medicine_name");
                    int qun=re.getInt("quantity");
                    double unit_price=re.getDouble("unit_price");
                    int quntity=re.getInt("quantity");
                    Total=Total+(unit_price*quntity);
                    sales.setText("Total Sales");
                    Amount.setText(String.valueOf(Total));
                    series.getData().add(new XYChart.Data<>(med,qun));
                }
                line_chart.getData().add(series);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        if(type=="Attendance Report" && limit=="Daily"){
            line_chart.getData().clear();
            System.out.println("attendance and daily");
            title.setText("");
            title.setText("Attendance Report : Day");
            line_chart.setTitle("");
            line_chart.setTitle("Attendance Report :"+LocalDate.now());
            xaxis.getCategories().clear();
            try {
                PreparedStatement preparedStatement = con.prepareStatement(" select e.position,count(e.position) from employee e left join attendance a on a.emp_id=e.emp_id where a.date=? group by e.position");
                preparedStatement.setString(1, String.valueOf(LocalDate.now()));
                ResultSet re=preparedStatement.executeQuery();

                XYChart.Series<String,Number> series=new XYChart.Series<>();
                while(re.next()){
                    category.add(re.getString("position"));
                    List<String> cate= new ArrayList<>(category);
                    Collections.sort(cate);
                    xaxis.setCategories(FXCollections.observableArrayList(cate));
                    series.getData().add(new XYChart.Data<>(re.getString("position"),re.getInt(2)));
                }

                line_chart.getData().add(series);
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        if(type=="Attendance Report"  && limit=="Monthly"){
            line_chart.getData().clear();
            xaxis.getCategories().clear();
            System.out.println("attendance and monthly");
            title.setText("");
            title.setText("Attendance Report : Month");
            line_chart.setTitle("");
            line_chart.setTitle("Attendance Report :"+LocalDate.now().getYear()+"-"+LocalDate.now().getMonth());
            String month=String.valueOf(LocalDate.now().getYear());
            String Year=String.valueOf(LocalDate.now().getMonth());
            try{
                PreparedStatement preparedStatement = con.prepareStatement(" select e.position,count(e.position) from employee e left join attendance a on a.emp_id=e.emp_id where year(a.date)=? and month(a.date)=? group by e.position");
                preparedStatement.setString(1,Year);
                preparedStatement.setString(2,month);
                ResultSet re=preparedStatement.executeQuery();
                XYChart.Series<String,Number> series=new XYChart.Series<>();
            while(re.next()){
                category.add(re.getString("position"));
                List<String> cate= new ArrayList<>(category);
                Collections.sort(cate);
                xaxis.setCategories(FXCollections.observableArrayList(cate));
                series.getData().add(new XYChart.Data<>(re.getString(1),re.getInt(2)));

            }
                line_chart.getData().add(series);


        } catch (SQLException e) {
                System.out.println(e);
        }

    }
        if(type=="Attendance Report" && limit=="Yearly"){
            line_chart.getData().clear();
            xaxis.getCategories().clear();
            System.out.println("attendance and yearly");
            title.setText("");
            title.setText("Attendance Report : Yearly");
            line_chart.setTitle("");
            line_chart.setTitle("Attendance Report :"+LocalDate.now().getYear());
            try{
                PreparedStatement preparedStatement = con.prepareStatement("select e.position,count(e.position) from employee e left join attendance a on a.emp_id=e.emp_id where year(a.date)=? group by e.position");
                preparedStatement.setString(1, String.valueOf(LocalDate.now().getYear()));
                ResultSet re=preparedStatement.executeQuery();
                XYChart.Series<String,Number> series=new XYChart.Series<>();

                while(re.next()){
                    category.add(re.getString("position"));
                    List<String> cate= new ArrayList<>(category);
                    Collections.sort(cate);
                    xaxis.setCategories(FXCollections.observableArrayList(cate));
                    series.getData().add(new XYChart.Data<>(re.getString("position"),re.getInt(2)));
                }

                line_chart.getData().add(series);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        if(type=="Stock report"){
            System.out.println("shock report.....");
            line_chart.getData().clear();
            xaxis.getCategories().clear();
            title.setText("");
            title.setText("Stock Report : Real Time");
            line_chart.setTitle("");
            line_chart.setTitle("Stock Report :"+LocalDate.now());
            try{
                PreparedStatement preparedStatement = con.prepareStatement("select m.medicine_name, s.quantity from stock s left join medicine m on m.medicine_id=s.medicine_id;");
                ResultSet re=preparedStatement.executeQuery();

                XYChart.Series<String,Number> series=new XYChart.Series<>();
                while(re.next()){
                    category.add(re.getString("medicine_name"));
                    List<String> cate= new ArrayList<>(category);
                    Collections.sort(cate);
                    xaxis.setCategories(FXCollections.observableArrayList(cate));
                    series.getData().add(new XYChart.Data<>(re.getString("medicine_name"),re.getInt("quantity")));
                }
                line_chart.getData().add(series);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxm = new FXMLLoader(Report_section.class.getResource("Report_section.fxml"));
        Scene scene = new Scene(fxm.load(), 981, 542);
        stage.setTitle("Report section");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public void type() {
        report_type.getItems().addAll("Sales Report","Attendance Report","Stock report");
    }

    public void limit() {
        time_limit.getItems().addAll("Daily","Monthly","Yearly");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
