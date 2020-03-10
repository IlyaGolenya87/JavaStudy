package com.example.myapp.model;

import com.google.gson.annotations.SerializedName;      //модель, позволяющая отправить данные на сервер

public class LoginRequest {

    @SerializedName("email")
    public String Email;

    @SerializedName("password")
    public String Password;
}
