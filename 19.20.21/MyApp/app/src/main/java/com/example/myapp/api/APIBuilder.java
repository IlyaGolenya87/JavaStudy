package com.example.myapp.api;

import com.google.gson.Gson;

import java.lang.reflect.Method;

import retrofit2.Call;
import retrofit2.Callback;

public class APIBuilder<Request, Response> {

    public interface onCallback<Response> {
        void onResponce(Response r);

        void onError(Exception e);
    }


    public void execute(String call, Request req, final Class<Response> respT, final onCallback callback) {
        MyFamily api = ApiService.getInstance().getApi();

        //Рефлексия
        // Получаем метод интерфейса MyFamily по его названию
        Method method = null;
        try {
            method = api.getClass().getMethod(call, req.getClass());


            // Вызываем полученный метод

            Call<Response> request = (Call<Response>) method.invoke(api, req);

            request.enqueue(new Callback<Response>() {

                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    Response res;
                    if (!response.isSuccessful()) {
                        Gson g = new Gson();
                        res = g.fromJson(response.errorBody().charStream(), respT);
                    } else {
                        res = response.body();
                    }
                    callback.onResponce(res);
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
