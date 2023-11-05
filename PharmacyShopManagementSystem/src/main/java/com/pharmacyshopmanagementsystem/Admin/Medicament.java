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
package com.pharmacyshopmanagementsystem.Admin;

public class Medicament {

    private String medId;     // Use camelCase for variable names
    private String medFname;  // Use camelCase for variable names
    private String medTpno;   // Use camelCase for variable names
    private String medEmail;  // Use camelCase for variable names

    public Medicament(String medId, String medFname, String medTpno, String medEmail) {
        this.medId = medId;
        this.medFname = medFname;
        this.medTpno = medTpno;
        this.medEmail = medEmail;

    }

    public Medicament() {
    }

    public String getMedId() {
        return medId;
    }

    public void setMedId(String medId) {
        this.medId = medId;
    }

    public String getMedFname() {
        return medFname;
    }

    public void setMedFname(String medFname) {
        this.medFname = medFname;
    }

    public String getMedTpno() {
        return medTpno;
    }

    public void setMedTpno(String medTpno) {
        this.medTpno = medTpno;
    }

    public String getMedEmail() {
        return medEmail;
    }

    public void setMedEmail(String medEmail) {
        this.medEmail = medEmail;
    }
}


