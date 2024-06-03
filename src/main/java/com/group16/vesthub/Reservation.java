package com.group16.vesthub;

public class Reservation {
    private int id;
    private int houseID;
    private String ownerMail;
    private String clientMail;
    private String daytime;
    private String date;
    private String status;
    private String message;

    Reservation() {
    }

    Reservation(int id, int houseID, String ownerMail, String clientMail, String daytime, String date, String status, String message) {
        this.id = id;
        this.houseID = houseID;
        this.ownerMail = ownerMail;
        this.clientMail = clientMail;
        this.daytime = daytime;
        this.date = date;
        this.status = status;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) {
        this.ownerMail = ownerMail;
    }

    public String getClientMail() {
        return clientMail;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
