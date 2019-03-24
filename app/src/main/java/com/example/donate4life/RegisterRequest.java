package com.example.donate4life;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class RegisterRequest extends Response {

    @SerializedName("macAddress")
    @Expose
    String macAddress;
    @SerializedName("name")
    @Expose
    String name;

    public RegisterRequest(String macAddress, String name) {
        this.macAddress = macAddress;
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
