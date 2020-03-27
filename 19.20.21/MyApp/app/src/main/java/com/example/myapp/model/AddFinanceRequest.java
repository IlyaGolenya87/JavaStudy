package com.example.myapp.model;

import com.google.gson.annotations.SerializedName;

public class AddFinanceRequest {

    @SerializedName("date")
    public String date;

    @SerializedName("sum")
    public float sum;

    @SerializedName("creditlabel")
    public String creditlabel;

}
