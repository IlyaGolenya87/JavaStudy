package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapp.api.ApiService;
import com.example.myapp.model.LoginRequest;
import com.example.myapp.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText login = findViewById(R.id.login); //    вытаскиваем нужное текстовое поле по id
        final EditText password = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginBtn); //вытаскиваем кнопку
        final TextView errormsg = findViewById(R.id.errorMsg);
        final TextView errormsg1 = findViewById(R.id.errorMsg1);
        TextView signUpBtn = findViewById(R.id.signUpBtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartActivity();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {     //добаваляем слушателя
            @Override
            public void onClick(View v) {
                String errorlogin = "";
                String errorPassword = "";
                if (login.getText().toString().equals("")) {
                    errorlogin = "Заполните поле \"e-mail\"\n";
                }
                if (password.getText().toString().equals("")) {
                    errorPassword = "Заполните поле \"ПАРОЛЬ\"\n";
                }
                if (!errorPassword.equals("")) {
                    errormsg1.setVisibility(View.VISIBLE);
                    errormsg1.setText(errorPassword);
                }
                if (!errorlogin.equals("")) {
                    errormsg.setVisibility(View.VISIBLE);
                    errormsg.setText(errorlogin);
                }
                if (errorPassword.equals("") && errorlogin.equals("")) {
                    //showMenuActivity();

                    loginUser(login.getText().toString(), password.getText().toString());      //метод отсылает на сервер введенные пользователем логин и пароль и в случае успеха переходит на следущее активити (реализация см. ниже)
                }
            }
        });
        //вызываемый метод добавляет слушателя для изменения текста
        login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                errormsg.setText("");
                errormsg.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                errormsg1.setText("");
                errormsg1.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }

    public void loginUser(String email, String password) {
        final LoginRequest loginRequest = new LoginRequest();
        loginRequest.Email = email;
        loginRequest.Password = password;

        ApiService.getInstance()
                .getApi()
                .login(loginRequest)
                .enqueue(new Callback<LoginResponse>() {       //здесь начинается работа с сервером
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {        //сработает если все прошло хорошо
                LoginResponse loginResponse = response.body();
                if (!loginResponse.result){
                    //TODO: обработка ошибки


                }else {
                    //TODO: сохранить token в памяти устройства
                    showMenuActivity();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {      //сработает если произошла ошибка (если прервался запрос или ответ)

                //TODO: обработка ошибки

            }
        });

    }

    public void showStartActivity() {
        Intent i = new Intent(this, StartActivity.class);
        startActivity(i);
    }

    public void showMenuActivity() {
        Intent i = new Intent(this, MenuActivity.class);        //Запуск активити. Создаем объект Intent и передаем в конструктор параметры: откуда (this) запуск и куда
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);     //указание андроиду, что меню станет главным активити (нужно для того, чтобы при нажатии стрелки назад не возвращалось в активити с логином)
        startActivity(i);

    }
}
