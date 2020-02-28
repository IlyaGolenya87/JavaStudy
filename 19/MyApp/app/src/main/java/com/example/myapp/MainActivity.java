package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

                if (!errorlogin.equals("")) {
                    errormsg.setVisibility(View.VISIBLE);
                    errormsg.setText(errorlogin);

                    if (!errorPassword.equals("")) {
                        errormsg1.setVisibility(View.VISIBLE);
                        errormsg1.setText(errorPassword);
                        return;
                    }
                    return;
                }else {
                    showMenuActivity();
                }


            }
        });


    }
    public void showMenuActivity (){
        Intent i = new Intent(this, MenuActivity.class);        //Запуск активити. Создаем объект Intent и передаем в конструктор параметры: откуда (this) запуск и куда
        startActivity(i);

    }
}
