//package com.pharmacyshopmanagementsystem;

/*public class Medicament {



    String med_Id;
    String med_Fname;
    String med_Tpno;
    String med_email;

    //public Medicament(String med_Name) {
      //  this.med_Name = med_Name;
   // }

    public Medicament(String med_Id, String med_Fname,String med_Tpno,String med_email) {
        this.med_Id= med_Id;
        this.med_Fname = med_Fname;
        this.med_Tpno = med_Tpno;
        this.med_email = med_email;

    }

    public Medicament() {
    }

    public String getMed_ID() {
        return this.med_Id;
    }

    public void setMed_ID(String med_Id) {
        this.med_Id = med_Id;
    }

    public String getMed_FName() {
        return this.med_Fname;
    }

    public void setMed_FName(String med_Fname) {
        this.med_Fname = med_Fname;
    }

    public String getMed_TPNO() {
        return this.med_Tpno;
    }

    public void setMed_TPNO(String med_Tpno) {
        this.med_Tpno = med_Tpno;
    }

    public String getMed_EMAIL() {
        return this.med_email;
    }

    public void setMed_EMAIL(String med_email) {
        this.med_email = med_email;
    }

}

 */
package com.pharmacyshopmanagementsystem.Employee;

public class Medicament {

    private String cusId;     // Use camelCase for variable names
    private String cusFname;  // Use camelCase for variable names
    private String cusLname;  // Use camelCase for variable names
    private String cusDOB;   // Use camelCase for variable names
    private String cusAddress;  // Use camelCase for variable names
    private String custpno;  // Use camelCase for variable names



    public Medicament(String cusId, String cusFname, String cusLname, String cusDOB, String cusAddress, String custpno) {
        this.cusId = cusId;
        this.cusFname = cusFname;
        this.cusLname = cusLname;
        this.cusDOB = cusDOB;
        this.cusAddress = cusAddress;
        this.custpno = custpno;

    }

    public Medicament() {
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusFname() {
        return cusFname;
    }

    public void setCusFname(String cusFname) {
        this.cusFname = cusFname;
    }

    public String getCusLname() {
        return cusLname;
    }

    public void setCusLname(String cusLname) {
        this.cusLname = cusLname;
    }


    public void setCusDOB(String cusDOB) {
        this.cusDOB = cusDOB;
    }

    public String getCusDOB() {
        return cusDOB;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCustpno() {
        return custpno;
    }

    public void setCustpno(String custpno) {
        this.custpno = custpno;
    }


}


