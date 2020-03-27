package com.example.myapp.model;

import com.google.gson.annotations.SerializedName;

public class AddFinanceResponse {

    @SerializedName("result")
    public boolean result;      //true/false в завизимости от того были ли ошибки

    @SerializedName("error")       //сохраняет текст ошибки (если она произошла)
    public String error;


}
