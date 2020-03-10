package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.DnsResolver;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp.api.ApiService;
import com.example.myapp.model.LoginRequest;
import com.example.myapp.model.LoginResponse;
import com.example.myapp.model.RegistrationRequest;
import com.example.myapp.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText email = findViewById(R.id.email);
        final EditText name = findViewById(R.id.name);
        final EditText password = findViewById(R.id.password);
        final EditText confirmPassword = findViewById(R.id.confirmPassword);


        Button okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "";
                if (email.getText().toString().equals("")) {
                    error += "Введите e-mail\n";
                }
                if (name.getText().toString().equals("")) {
                    error += "Введите имя\n";
                }
                if (password.getText().toString().equals("")) {
                    error += "Введите пароль\n";
                }
                if (confirmPassword.getText().toString().equals("")) {
                    error += "Повторите ввод пароля\n";
                }

                if (!password.getText().toString().equals("") && confirmPassword.getText().toString().equals("")) {      //если оба пароля не пустые - сверяем их между собой

                    if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                        error += "Пароли должны совпадать";
                    }
                }

                if (!error.equals("")) {        //если есть хоть одна ошибка, вызываем всплывающий диалог с этой ошибкой
                    showError(error);
                    return;
                }
                registerUser(email.getText().toString(), name.getText().toString(), password.getText().toString());
            }
        });
    }

    public void showError(String error) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);       //Создание всплывающего диалога с ошибкой, нужно передать this, чтобы было понятно из какого активити он вызван
        alert.setMessage(error);
        alert.setTitle("Ошибка!");
        alert.setCancelable(true);      //задаем возможность скрыть диалог, нажатием на пустой экран
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {       //в диалоге создается кнопка, для закрытия диалога, передаем текст, которй буте на ней и слушателя
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }      //если оставить метод пустым, диалог просто исчезнет при нажатии кнопки
        });
        //alert.setIcon() //метод позволяет задать иконку для диалога
        alert.create().show();

    }

    public void registerUser(String email, String name, String password) {      //Метод, обеспечивающий регистрацию пользователя
        final RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.email = email;
        registrationRequest.name = name;
        registrationRequest.password = password;

        ApiService.getInstance()
                .getApi()
                .registration(registrationRequest)
                .enqueue(new Callback<RegistrationResponse>() {
                    @Override
                    public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                        RegistrationResponse registrationResponse = response.body();
                        if (!registrationResponse.result) {
                            showError(registrationResponse.error);
                        } else {
                            showConfirmActivity();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                        showError(t.getMessage());

                    }
                });
    }

    public void showConfirmActivity() {
        Intent i = new Intent(this, ConfirmActivity.class);
        startActivity(i);
    }
}
