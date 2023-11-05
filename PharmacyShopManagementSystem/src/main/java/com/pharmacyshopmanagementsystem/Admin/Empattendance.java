package com.pharmacyshopmanagementsystem.Admin;

public class Empattendance {
    private String empId;     // Use camelCase for variable names
    private String empDate;  // Use camelCase for variable names


    public Empattendance(String emp_Id,String emp_Date) {
        this.empId = emp_Id;
        this.empDate = emp_Date;


        System.out.println("///////////////////////////////");
        System.out.println(emp_Id);
       System.out.println(emp_Date);

    }

    public Empattendance() {
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpDate() {
        return empDate;
    }

    public void setEmpDate(String empDate) {
        this.empDate = empDate;
    }


}
