package com.example.myapp.api;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIBuilder<Request, Response> {

    public interface onCallback<Response> {
        void onResponce(Response r);

        void onError(Exception e);
    }


    public void execute(String call, Request req, final onCallback callback) {
        MyFamily api = ApiService.getInstance().getApi();

        //Рефлексия

        // Получаем метод интерфейса MyFamily по его названию
        Method method = null;
        try {
            method = api.getClass().getMethod(call, req.getClass());


            // Выдываем полученный метод

            Call<Response> request = (Call<Response>) method.invoke(api, req);

            request.enqueue(new Callback<Response>() {

                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    Response res;
                    if (!response.isSuccessful()) {
                        Gson g = new Gson();
                        Type responseType = new TypeToken<Response>() {
                        }.getType();
                        res = g.fromJson(response.errorBody().charStream(), responseType);
                    } else {
                        res = response.body();
                    }


                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {
                    callback.onError(new Exception(t));


                }
            });
        } catch (Exception e) {
            callback.onError(e);
        }
    }


}
