package com.example.donate4life;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    public RegisterResponse(RegisterData registerData) {
        this.registerData = registerData;
    }

    @SerializedName("data")

    RegisterData registerData;

    public RegisterData getRegisterData() {
        return registerData;
    }

    public void setRegisterData(RegisterData registerData) {
        this.registerData = registerData;
    }
}
