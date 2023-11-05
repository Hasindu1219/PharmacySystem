package com.pharmacyshopmanagementsystem.customer;

public class Medicament {
        private String cusId;
        private String FirstName;

        private String LastName;
        private String dob;
        private String address;
        private String custpno;

        public Medicament(String cusId, String FirstName, String LastName, String dob, String address,String custpno) {
            this.cusId = cusId;
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.dob = dob;
            this.address = address;
            this.custpno = custpno;


            System.out.println("IN Medicament: "+cusId+"|"+FirstName+"|"+LastName+"|"+dob+"|"+address+"|"+custpno);
        }

        public Medicament() {
        }

        public String getCusId() {
            return cusId;
        }

        public void setCusId(String cusId) {
            this.cusId = cusId;
        }

    public String getFirstName() {
            return FirstName;
        }
        public void setFirstName(String FirstName) {
            this.FirstName =FirstName;
        }
        public String getLastName() {
            return LastName;
        }
        public void setLastName(String LastName) {
            this.LastName =LastName;
        }
        public String getDob() {
            return dob;
        }
        public void setDob(String dob) {
            this.dob=dob;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address=address;
        }
        public String getCustpno() {
            return custpno;
        }
        public void setCustpno(String custpno) {
            this.custpno =custpno;
        }


}
