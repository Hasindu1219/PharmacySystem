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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

public class Report_section extends Application {
    @FXML
    private Pane chart_pannel;
    @FXML
    private Label ld_date;
    @FXML
    private ComboBox<String> report_type;

    @FXML
    private ComboBox<String> time_limit;

    @FXML
    private ComboBox<String> Date_date;

    @FXML
    private ComboBox<String> Date_month;

    @FXML
    private ComboBox<String> Date_year;

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

int return_value(){
        String s=Date_month.getValue();
int res=0;
    if(s=="January"){
        return res=1;
    }
    else if(s=="February"){
        return res=2;
    }
    else if(s=="March"){
        return res=3;
    }
    else if(s=="April"){
        return res=4;
    }
    else if(s=="May"){
        return res=5;
    }
    else if(s=="June"){
        return res=6;
    }
    else if(s=="July"){
        return res=7;
    }
    else if(s=="August"){
        return res=8;
    }
    else if(s=="September"){
        return res=9;
    }
    else if(s=="October"){
        return  res=10;
    }
    else if(s=="November"){
        return res=11;
    }
    else if(s=="December"){
        return res=12;
    }

    return res;
}
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
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(Date_year.getValue()));
            calendar.set(Calendar.MONTH, return_value() - 1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(Date_date.getValue()));
            Date userDate = calendar.getTime();
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String format_date=dateFormat.format(userDate);
            title.setText("");
            title.setText("Sales Report : Day");
            line_chart.setTitle("");
            line_chart.setTitle("Sales of The Day :"+format_date);
            XYChart.Series<String,Number> series=new XYChart.Series<>();
            series.setName("Sales Data");
            try{
            PreparedStatement preparedStatement = con.prepareStatement("select m.medicine_name,s.quantity,m.unit_price from medicine m left join sale s on m.medicine_id=s.medicine_id where s.sale_date=?");
            preparedStatement.setString(1, format_date);
            ResultSet re=preparedStatement.executeQuery();

double Total = 0;
          while(re.next()){
              category.add(re.getString("medicine_name"));
              List<String> cate= new ArrayList<>(category);
              Collections.sort(cate);
              xaxis.setCategories(FXCollections.observableArrayList(cate));
                double unit_price=re.getDouble("unit_price");
                int quntity=re.getInt("quantity");
                Total=(Total)+(unit_price*quntity);
                sales.setText("Total Sales");
                Amount.setText(String.valueOf(Total));

                series.getData().add(new XYChart.Data<>(re.getString("medicine_name"),re.getInt("quantity")));

            }
                line_chart.getData().add(series);



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
            line_chart.setTitle("Sales of The Month :"+Date_year.getValue()+" - "+Date_month.getValue());
            try{
                PreparedStatement preparedStatement = con.prepareStatement("select m.medicine_name,s.quantity,m.unit_price from medicine m left join sale s on m.medicine_id=s.medicine_id where year(s.sale_date)=? and month(s.sale_date)=?");
                preparedStatement.setString(1, Date_year.getValue());
                preparedStatement.setString(2, String.valueOf(return_value()));
                ResultSet re=preparedStatement.executeQuery();
                XYChart.Series<String,Number> series=new XYChart.Series<>();
                double Total=0;
                while (re.next()){
                    category.add(re.getString("medicine_name"));
                    List<String> cate= new ArrayList<>(category);
                    Collections.sort(cate);
                    xaxis.setCategories(FXCollections.observableArrayList(cate));
                    double unit_price=re.getDouble("unit_price");
                    int quntity=re.getInt("quantity");
                    Total=(Total)+(unit_price*quntity);
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
            line_chart.setTitle("Sales of The Year :"+Date_year.getValue());

            try{
                PreparedStatement preparedStatement = con.prepareStatement("select m.medicine_name,s.quantity,m.unit_price from medicine m left join sale s on m.medicine_id=s.medicine_id where year(s.sale_date)=?");
                preparedStatement.setString(1,Date_year.getValue());
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
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(Date_year.getValue()));
            calendar.set(Calendar.MONTH, return_value() - 1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(Date_date.getValue()));
            Date userDate = calendar.getTime();
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String format_date=dateFormat.format(userDate);
            System.out.println("attendance and daily");
            title.setText("");
            title.setText("Attendance Report : Day");
            line_chart.setTitle("");
            line_chart.setTitle("Attendance Report :"+format_date);
            xaxis.getCategories().clear();

            try {
                PreparedStatement preparedStatement = con.prepareStatement(" select e.position,count(e.position) from employee e left join attendance a on a.emp_id=e.emp_id where a.date=? group by e.position");
                preparedStatement.setString(1, format_date);
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
            line_chart.setTitle("Attendance Report :"+Date_year.getValue()+"-"+Date_month.getValue());
            String month=Date_month.getValue();

            String Year=Date_year.getValue();
            try{
                PreparedStatement preparedStatement = con.prepareStatement(" select e.position,count(e.position) from employee e left join attendance a on a.emp_id=e.emp_id where year(a.date)=? and month(a.date)=? group by e.position");
                preparedStatement.setString(1,Date_year.getValue());
                preparedStatement.setString(2,Date_month.getValue());
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
            line_chart.setTitle("Attendance Report :"+Date_year.getValue());
            try{
                PreparedStatement preparedStatement = con.prepareStatement("select e.position,count(e.position) from employee e left join attendance a on a.emp_id=e.emp_id where year(a.date)=? group by e.position");
                preparedStatement.setString(1, Date_year.getValue());
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
        if(time_limit.getValue()=="Yearly"){

            Date_month.setVisible(false);
            Date_date.setVisible(false);
            Date_year.setVisible(true);
            ld_date.setVisible(true);
        }
        if(time_limit.getValue()=="Monthly"){
            Date_date.setVisible(false);
            Date_year.setVisible(true);
            Date_month.setVisible(true);
            ld_date.setVisible(true);
        }
        if(time_limit.getValue()=="Daily"){
            Date_year.setVisible(true);
            Date_month.setVisible(true);
            Date_date.setVisible(true);
            ld_date.setVisible(true);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void D_year() {
        try {
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps= con.prepareStatement("select date from attendance");
            ResultSet re=ps.executeQuery();
            int d=0;
            while(re.next()){
                Date date1=dateFormat.parse(re.getString("date"));
                d=date1.getYear()+1900;
                System.out.println(d);

            }
            Date_year.getItems().addAll(String.valueOf(d));
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public void D_month() {
        Date_month.getItems().addAll("January","February","March","April","May","June","July","August","September","October","November","December");
    }

    public void D_date() {
        int i;
        for (i=1;i<32;i++){
            Date_date.getItems().addAll(String.valueOf(i));
        }
    }
}
