package com.example.myapp.api;

import com.example.myapp.model.ConfirmRequest;
import com.example.myapp.model.ConfirmResponse;
import com.example.myapp.model.LoginRequest;
import com.example.myapp.model.LoginResponse;
import com.example.myapp.model.RegistrationRequest;
import com.example.myapp.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyFamily {     //В интерфейсе прописываются все конечные точки, доступные на сервере

    @POST("/login")     //тип запроса, в скобках указывается дописка к baseURL

    Call <LoginResponse> login (@Body LoginRequest request);        //Call - класс из ретрофита, метод login будет возвращать JSON, преобразует в объект LoginResponse. В скобках указано то, что мы отправляем

    @POST("/registration")     //тип запроса, в скобках указывается дописка к baseURL

    Call <RegistrationResponse> registration (@Body RegistrationRequest request);

    @POST("/confirm")     //тип запроса, в скобках указывается дописка к baseURL

    Call <ConfirmResponse> confirm (@Body ConfirmRequest request);


}
