package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        CardView financeBtn = findViewById(R.id.financeBtn);
        financeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showActivity(FinanceActivity.class);

            }
        });
    }


    public void showActivity (Class activity) {
        Intent intent = new Intent (this, activity);
        startActivity(intent);
    }

}
