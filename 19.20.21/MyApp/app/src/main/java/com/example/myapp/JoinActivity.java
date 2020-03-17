package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp.Utils.Dialog;
import com.example.myapp.api.APIBuilder;
import com.example.myapp.model.JoinRequest;
import com.example.myapp.model.JoinResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinActivity extends AppCompatActivity {
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        email = findViewById(R.id.email);
        Button joinBtn = findViewById(R.id.joinBtn);

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().equals("")) {
                    Dialog.showErrorDialog(JoinActivity.this, "Укажите e-mail для отправки приглашения");
                    return;

                }

                //проверка корректности ввода e-mail
                String regex = "^(.+)@(.+)$";       //регулярное выражение
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email.getText().toString());
                if (!matcher.matches()) {
                    Dialog.showErrorDialog(JoinActivity.this, "Укажите корректный e-mail");
                    return;
                }

                join(email.getText().toString());

            }

        });

    }

    public void join(String email) {

        JoinRequest joinRequest = new JoinRequest();
        joinRequest.email = email;

        APIBuilder<JoinRequest, JoinResponse> builder = new APIBuilder<>();
        builder.execute("join", joinRequest, JoinResponse.class, new APIBuilder.onCallback<JoinResponse>() {
            @Override
            public void onResponce(JoinResponse resp) {
                Dialog.showDialog(JoinActivity.this, "Запрос отправлен по указанному e-mail");
                JoinActivity.this.email.setText("");
            }

            @Override
            public void onError(Exception e) {

                Dialog.showErrorDialog(JoinActivity.this, e.getMessage());

            }
        });

    }
}
