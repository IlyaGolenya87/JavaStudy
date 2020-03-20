package com.example.myapp.api;
import com.example.myapp.model.ConfirmRequest;
import com.example.myapp.model.ConfirmResponse;
import com.example.myapp.model.FinanceResponse;
import com.example.myapp.model.JoinRequest;
import com.example.myapp.model.JoinResponse;
import com.example.myapp.model.LoginRequest;
import com.example.myapp.model.LoginResponse;
import com.example.myapp.model.RegistrationRequest;
import com.example.myapp.model.RegistrationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyFamily {     //В интерфейсе прописываются все конечные точки, доступные на сервере

    @POST("/login")     //тип запроса, в скобках указывается дописка к baseURL
    Call <LoginResponse> login (@Body LoginRequest request);        //Call - класс из ретрофита, метод login будет возвращать JSON, преобразует в объект LoginResponse. В скобках указано то, что мы отправляем

    @POST("/register")     //тип запроса, в скобках указывается дописка к baseURL
    Call <RegistrationResponse> registration (@Body RegistrationRequest request);

    @POST("/submit")     //тип запроса, в скобках указывается дописка к baseURL
    Call <ConfirmResponse> confirm (@Body ConfirmRequest request);

    @POST("/join")     //тип запроса, в скобках указывается дописка к baseURL
    Call <JoinResponse> join (@Body JoinRequest request);

    @GET ("/finance")   //get-запрос на сервер
    Call <FinanceResponse> getfinance (@Query("startAt") String start, @Query("endAt") String end);     //дополнительные параметры в запросе GET передаются в Querry
    //Query - часть адреса, расположенная после знака "?"
    //параметры задаются в виде "ключ = значение"
    //между собой параметры разделяются знаком "&"
    //чтобы задать Query параметр в ретрофит необходимо использовать директиву @Query("key"), в скобках - название параметра
    //ретрофит автоматически задаст параметру значение, указанное в аргументе, следующем за директивой
    //Запрос будет выглядеть примерно так:
    //<server>/finance?startAt=01-01-2020&endAt31-01-2020 - то, что сформирурует ретрофит в качестве запроса. Даты - как пример (значения переменных start  и end)


}
