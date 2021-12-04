package com.samar.holihome;

import java.io.Serializable;

public class Admin implements Serializable {


    public String name, password;



    public Admin(String name,  String password) {
        this.name = "admin";
        this.password = "pass";

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}