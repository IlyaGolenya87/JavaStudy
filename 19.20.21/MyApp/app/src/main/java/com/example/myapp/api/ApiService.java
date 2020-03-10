package com.example.myapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {       //Класс будет предназначаться для обмена данными с сервером

    //Паттерн Singleton
    //Создается статический класс getInstance, возвращающий сущность, данного класса

    private Retrofit mRetrofit;

    private static ApiService instance;
    public static ApiService getInstance(){
        if (instance == null){
            //инициализация instance
            instance = new ApiService();
            //Паттерн FabricBuilder (Фабричный конструктор)
            instance.mRetrofit = new Retrofit.Builder()
                    .baseUrl("http://127.0.0.1:8080")       //основной адрес сервера
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return instance;
    }


    public MyFamily getApi (){      //создает объект типа Myfamily через ретрофит,
        return mRetrofit.create(MyFamily.class);
    }

}
