package com.example.donate4life;

import java.util.List;

public class Response {
    int status;
    String info;

    String error;
    List errorList;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List getErrorList() {
        return errorList;
    }

    public void setErrorList(List errorList) {
        this.errorList = errorList;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
