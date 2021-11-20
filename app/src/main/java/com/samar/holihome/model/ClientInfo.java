package com.samar.holihome.model;

public class ClientInfo {
    private String ClientName;

    // string variable for storing
    // employee contact number
    private String ClientContactNumber;

    // string variable for storing
    // employee address.
    private String ClientDate;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public ClientInfo() {

    }

    public String getClientDate() {
        return ClientDate;
    }

    public void setClientDate(String clientDate) {
        ClientDate = clientDate;
    }

    public String getClientContactNumber() {
        return ClientContactNumber;
    }

    public void setClientContactNumber(String clientContactNumber) {
        ClientContactNumber = clientContactNumber;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }
}
