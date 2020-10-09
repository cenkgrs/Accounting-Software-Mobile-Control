package com.example.accountingsoftware;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListBookingsActivity extends AppCompatActivity {

    private static final String url = "jdbc:mysql://localhost:3306/stock";
    private static final String user = "root";
    private static final String pass = "password";

    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = (TextView) this.findViewById(R.id.textView2);
    }

    private class ConnectMySql extends AsyncTask<String, Void, String> {
        String res = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(ListBookingsActivity.this, "Please wait...", Toast.LENGTH_SHORT)
                    .show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                System.out.println("Databaseection success");

                String result = "Database Connection Successful\n";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select name from products");
                ResultSetMetaData rsmd = rs.getMetaData();

                while (rs.next()) {
                    result += rs.getString(1).toString() + "\n";
                }
                res = result;
            } catch (Exception e) {
                e.printStackTrace();
                res = e.toString();
            }
            return res;
        }

        @Override
        protected void onPostExecute(String result) {
            txtData.setText(result);
        }
    }
}