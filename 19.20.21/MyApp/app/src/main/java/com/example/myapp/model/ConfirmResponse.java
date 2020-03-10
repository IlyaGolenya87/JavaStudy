package com.example.myapp.model;

import com.google.gson.annotations.SerializedName;

public class ConfirmResponse {
    @SerializedName("result")
    public boolean result;      //true/false в завизимости от того были ли ошибки

    @SerializedName("error")       //сохраняет текст ошибки (если она произошла)
    public String error;

    @SerializedName("token")        //строка в которой зашифрована информация о пользователе, будет посылаться в каждом запросе, расшифровываться и проверять есть ли доступ к ресурсу
    public String token;


}
