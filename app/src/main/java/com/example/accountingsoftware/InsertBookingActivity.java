package com.example.accountingsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_booking);

        final EditText productInput = findViewById(R.id.productInput);
        final EditText amountInput = findViewById(R.id.amountInput);
        final EditText priceInput = findViewById(R.id.priceInput);


        final Button insertButton = findViewById(R.id.insert_button);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("cl,cled");



                String product = productInput.getText().toString();
                String amount = amountInput.getText().toString();
                String price = priceInput.getText().toString();

                Connection conn = null;
                DbHelper dbHelper = new DbHelper();
                PreparedStatement st = null;
                ResultSet resultSet = null;

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = dbHelper.getConnection();
                    String sql = "INSERT INTO bookings(product_id, amount, total_price) VALUES(?, ?, ?)";
                    st = conn.prepareStatement(sql);
                    st.setString(1, product);
                    st.setString(2, amount);
                    st.setString(3, price);
                    st.executeUpdate();


                }catch (SQLException exception){
                    dbHelper.showErrorMessage(exception);
                }
                catch (ClassNotFoundException exception){
                    System.out.println(exception.getMessage());
                }

                System.out.println("Success");
            }
        });
    }
}