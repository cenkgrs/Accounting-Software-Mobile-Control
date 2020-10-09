package com.example.accountingsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button insert_button = findViewById(R.id.insert_button);
        insert_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentInsert = new Intent(MainActivity.this, InsertBookingActivity.class);
                MainActivity.this.startActivity(intentInsert);

                Log.i("Content "," Insert Layout ");
            }
        });

        final Button update_button = findViewById(R.id.update_button);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUpdate = new Intent(MainActivity.this, InsertBookingActivity.class);
                MainActivity.this.startActivity(intentUpdate);

                Log.i("Content", "Update log");
            }
        });

        final Button listButton = findViewById(R.id.list_button);

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("here");
                Intent intentList = new Intent(MainActivity.this, ListBookingsActivity.class);
                MainActivity.this.startActivity(intentList);

                Log.i("Content", "List log");
            }
        });
    }
}