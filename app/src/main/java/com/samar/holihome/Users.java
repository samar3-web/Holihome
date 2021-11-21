package com.samar.holihome;

import java.io.Serializable;

public class Users implements Serializable {


    public String name, email, password;



    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
