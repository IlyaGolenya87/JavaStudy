package com.example.myapp.model;

import com.google.gson.annotations.SerializedName;

public class RegistrationRequest {

    @SerializedName("email")
    public String email;

    @SerializedName("name")
    public String name;

    @SerializedName("password")
    public String password;

}
