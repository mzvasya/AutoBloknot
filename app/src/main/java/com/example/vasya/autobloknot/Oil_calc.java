package com.example.vasya.autobloknot;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Oil_calc extends ActionBarActivity {
    Button btnCount_oil, btnCount_trip, btnBack;
    EditText etDist, etDist2, etCoun, etCoun2;
    TextView textView28, textView32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil_calc);

        btnCount_oil = (Button)findViewById(R.id.btnCount_oil);
        btnCount_trip = (Button)findViewById(R.id.btnCount_trip);
        btnBack = (Button)findViewById(R.id.btnBack);
        etDist = (EditText)findViewById(R.id.etDist);
        etDist2 = (EditText)findViewById(R.id.etDist2);
        etCoun = (EditText)findViewById(R.id.etCoun);
        etCoun2 = (EditText)findViewById(R.id.etCoun2);
        textView28 = (TextView)findViewById(R.id.textView28);
        textView32 = (TextView)findViewById(R.id.textView32);
    }

    public void onClick(View view) {
        switch (view.getId() ){
            case R.id.btnCount_oil:
                if(etDist.getText().toString().trim().equals("")||etCoun.getText().toString().trim().equals("")){
                    Toast.makeText(this, "Введите даные", Toast.LENGTH_SHORT).show();
                } else {
                double a = Double.parseDouble(etDist.getText().toString());
                double b = Double.parseDouble(etCoun.getText().toString());
                double c = (b * 100) / a;
                double new_c = new BigDecimal(c).setScale(1, RoundingMode.DOWN).doubleValue();
                textView28.setText("Розход топлива " + new_c + "л/100км ");}
                break;
            case R.id.btnCount_trip:
                if(etDist2.getText().toString().trim().equals("")||etCoun2.getText().toString().equals("")){
                    Toast.makeText(this, "Введите даные", Toast.LENGTH_SHORT).show();
                } else {
                double a2 = Double.parseDouble(etDist2.getText().toString());
                double b2 = Double.parseDouble(etCoun2.getText().toString());
                double c2 = (b2 * 100) / a2;
                double new_c2 = new BigDecimal(c2).setScale(1, RoundingMode.DOWN).doubleValue();
                textView32.setText("У вас топлива на " + new_c2 + " км");}
                break;
            case R.id.btnBack:
                finish();
                break;
        }

    }
}
