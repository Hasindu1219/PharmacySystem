package com.pharmacyshopmanagementsystem.Employee;

public class MedicineTableAdd {

    private String med_Id;     // Use camelCase for variable names
    private String med_Name;  // Use camelCase for variable names
    private String med_Sid;  // Use camelCase for variable names
    private String med_Desciption;   // Use camelCase for variable names
    private String med_Uprice;  // Use camelCase for variable names
    private String med_Exp;  // Use camelCase for variable names

    public MedicineTableAdd(String med_Id, String med_Name, String med_Sid, String med_Desciption, String med_Uprice, String med_Exp) {
        this.med_Id = med_Id;
        this.med_Name = med_Name;
        this.med_Sid = med_Sid;
        this.med_Desciption = med_Desciption;
        this.med_Uprice = med_Uprice;
        this.med_Exp = med_Exp;
    }

    public MedicineTableAdd() {

    }

    public void setMed_Id(String med_Id) {
        this.med_Id = med_Id;
    }

    public void setMed_Name(String med_Name) {
        this.med_Name = med_Name;
    }

    public void setMed_Sid(String med_Sid) {
        this.med_Sid = med_Sid;
    }

    public void setMed_Desciption(String med_Desciption) {
        this.med_Desciption = med_Desciption;
    }

    public void setMed_Uprice(String med_Uprice) {
        this.med_Uprice = med_Uprice;
    }

    public void setMed_Exp(String med_Exp) {
        this.med_Exp = med_Exp;
    }

    public String getMed_Id() {
        return med_Id;
    }

    public String getMed_Name() {
        return med_Name;
    }

    public String getMed_Sid() {
        return med_Sid;
    }

    public String getMed_Desciption() {
        return med_Desciption;
    }

    public String getMed_Uprice() {
        return med_Uprice;
    }

    public String getMed_Exp() {
        return med_Exp;
    }


}
