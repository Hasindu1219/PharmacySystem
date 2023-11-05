package com.pharmacyshopmanagementsystem.user;

public class UserDetails {
    private static String myUserame=null;
    private static String myPassword=null;
    private static String myType=null;

    public static void setUserDetails(String username,String password){
        myUserame=username;
        myPassword=password;
    }

    public static String getUsername() {
        return myUserame;
    }
    public static String getPassword() {
        return myPassword;
    }


}
