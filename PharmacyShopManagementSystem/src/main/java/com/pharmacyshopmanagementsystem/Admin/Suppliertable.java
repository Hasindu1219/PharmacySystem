package com.pharmacyshopmanagementsystem.Admin;

public class Suppliertable {
    private String supId;     // Use camelCase for variable names
    private String supFname;  // Use camelCase for variable names
    private String supTpno;   // Use camelCase for variable names
    private String supAddress;  // Use camelCase for variable names

    public Suppliertable(String supId, String supFname, String supTpno, String supAddress) {
        this.supId = supId;
        this.supFname = supFname;
        this.supTpno = supTpno;
        this.supAddress = supAddress;

        System.out.println("///////////////////////////////");
        System.out.println(supTpno);
        System.out.println(supAddress);

    }

    public Suppliertable() {
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSupFname() {
        return supFname;
    }

    public void setSupFname(String supFname) {
        this.supFname = supFname;
    }

    public String getSupTpno() {
        return supTpno;
    }

    public void setSupTpno(String supTpno) {
        this.supTpno = supTpno;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }
}
