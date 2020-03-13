package com.example.myapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.api.ApiService;
import com.example.myapp.model.ConfirmRequest;
import com.example.myapp.model.ConfirmResponse;
import com.example.myapp.model.RegistrationResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirm);

        final EditText code = findViewById(R.id.code);
        Button confirmBtn = findViewById(R.id.confirmBtn);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (code.getText().toString().equals("")){
                    showError("Введите код подтверждения");
                    return;
                }
                confirmCode (code.getText().toString());    //проверка кода подтверждения
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

    public void confirmCode(String code){
        //Запрос на сервер
        final ConfirmRequest confirmRequest = new ConfirmRequest();
        confirmRequest.code = code;


        ApiService.getInstance()
                .getApi()
                .confirm(confirmRequest)
                .enqueue(new Callback<ConfirmResponse>() {

                    @Override
                    public void onResponse(Call<ConfirmResponse> call, Response<ConfirmResponse> response) {
                        /*ConfirmResponse confirmResponse = response.body();
                        if (!confirmResponse.result) {
                            showError(confirmResponse.error);
                        } else {
                            showMenuActivity();
                        }*/

                        ConfirmResponse confirmResponse = null;
                        if (!response.isSuccessful()){
                            Gson g = new Gson();
                            confirmResponse = g.fromJson(response.errorBody().charStream(), ConfirmResponse.class);

                        }else {
                            confirmResponse = response.body();
                        }

                        if (!confirmResponse.result) {
                            showError(confirmResponse.error);
                        } else {
                            showMenuActivity();
                        }

                    }

                    @Override
                    public void onFailure(Call<ConfirmResponse> call, Throwable t) {
                        showError(t.getMessage());

                    }
                });
    }

    public void showMenuActivity() {
        Intent i = new Intent(this, MenuActivity.class);        //Запуск активити. Создаем объект Intent и передаем в конструктор параметры: откуда (this) запуск и куда
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);     //указание андроиду, что меню станет главным активити (нужно для того, чтобы при нажатии стрелки назад не возвращалось в активити с логином)
        startActivity(i);

    }
}
