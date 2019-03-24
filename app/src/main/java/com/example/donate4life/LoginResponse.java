package com.example.donate4life;

import com.google.gson.annotations.SerializedName;

public class LoginResponse extends Response{

    @SerializedName("data")
    Data data;
    public LoginResponse(){}
    public LoginResponse(int status,String info, Data data) {
        this.status = status;
        this.info=info;
        this.data = data;
    }

    @Override
    public int getStatus() {

        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
