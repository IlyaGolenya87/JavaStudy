package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                }
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
            public void onClick(DialogInterface dialog, int which) { }      //если оставить метод пустым, диалог просто исчезнет при нажатии кнопки
        });
        //alert.setIcon() //метод позволяет задать иконку для диалога
        alert.create().show();

    }
}
