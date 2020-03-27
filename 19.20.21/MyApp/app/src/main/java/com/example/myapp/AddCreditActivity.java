package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapp.Utils.Dialog;
import com.example.myapp.api.APIBuilder;
import com.example.myapp.model.AddFinanceRequest;
import com.example.myapp.model.AddFinanceResponse;
import com.example.myapp.model.CreditLabels;

import java.lang.annotation.ElementType;
import java.util.Calendar;

public class AddCreditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_credit);

        Spinner credits = findViewById(R.id.credits);
        final EditText creditlabel = findViewById(R.id.creditLabel);
        final EditText sum = findViewById(R.id.sum);
        final EditText date = findViewById(R.id.date);
        final EditText time = findViewById(R.id.time);
        Button okBtn = findViewById(R.id.okBtn);

        //как и в случае с ListView для спинера нужен адаптер,
        //для спинера есть стандартный

        String[] data = new String[CreditLabels.values().length];
        int i = 0;
        for (CreditLabels label : CreditLabels.values()){
            data [i++] = label.getLabel();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, data);
        credits.setAdapter(adapter);
        credits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CreditLabels label = CreditLabels.values()[position];
                if (label == CreditLabels.OTHER){
                    creditlabel.setEnabled(true);
                    creditlabel.setText("");
                    creditlabel.requestFocus();

                }else {
                    creditlabel.setEnabled(false);
                    creditlabel.setText(label.getLabel());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Calendar calendar = Calendar.getInstance();
        String dateStr = String.format("%d/%d/%d", calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
        final String timeStr = String.format("%d:%d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
        date.setText(dateStr);
        time.setText(timeStr);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (creditlabel.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this, "Укажите статью затрат");
                    return;
                }
                if (sum.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this, "Укажите сумму ");
                    return;
                }
                if (date.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this, "Введите дату");
                    return;
                }
                if (time.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this, "Введите время");
                    return;
                }

                AddFinanceRequest addFinanceRequest = new AddFinanceRequest();
                addFinanceRequest.creditlabel = creditlabel.getText().toString();
                addFinanceRequest.date = date.getText().toString() + " " + time.getText().toString();

                try {
                    addFinanceRequest.sum = Float.valueOf(sum.getText().toString());
                }catch (Exception e){
                    Dialog.showErrorDialog(AddCreditActivity.this, e.getMessage());
                    return;
                }

                addCredit (addFinanceRequest);
            }
        });


    }

    public void addCredit(AddFinanceRequest req){
        APIBuilder <AddFinanceRequest, AddFinanceResponse> builder = new APIBuilder<>();
        builder.execute("addFinance", req, AddFinanceResponse.class, new APIBuilder.onCallback <AddFinanceResponse>() {
            @Override
            public void onResponce(AddFinanceResponse r) {

                if (!r.result){
                    Dialog.showErrorDialog(AddCreditActivity.this, r.error);
                    return;
                }

                onBackPressed();   // - программно "нажимает" кнопку "назад"
            }


            @Override
            public void onError(Exception e) {

                Dialog.showErrorDialog(AddCreditActivity.this, e.getMessage());

            }
        });
    }




}
