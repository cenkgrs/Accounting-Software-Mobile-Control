package com.example.accountingsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InsertBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_booking);

        final EditText codeInput = findViewById(R.id.codeInput);
        final EditText amountInput = findViewById(R.id.amountInput);

        final Button insertButton = findViewById(R.id.insert_button);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = codeInput.getText().toString();
                String amount = amountInput.getText().toString();

                System.out.println(code + "  " + amount);
            }
        });
    }
}