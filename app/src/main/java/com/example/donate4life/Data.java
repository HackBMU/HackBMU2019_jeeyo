package com.example.donate4life;

public class Data {

    String id;
    String email;

    public Data( String id, String email) {
        this.id = id;
        this.email = email;
    }

//    @Override
//    public int getStatus() {
//
//        return status;
//    }
//
//    @Override
//    public void setStatus(int status) {
//        this.status = status;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
