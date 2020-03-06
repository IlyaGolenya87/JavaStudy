package com.example.myapp.api;

import com.example.myapp.model.LoginRequest;
import com.example.myapp.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyFamily {     //В интерфейсе прописываются все конечные точки, доступные на сервере

    @POST("/login")     //тип запроса, в скобках указывается дописка к baseURL

    Call <LoginResponse> login (@Body LoginRequest request);        //Call - класс из ретрофита, метод login будет возвращать JSON, преобразует в объект LoginResponse. В скобках указано то, что мы отправляем



}
