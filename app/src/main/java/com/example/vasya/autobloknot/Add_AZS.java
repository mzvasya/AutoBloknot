package com.example.vasya.autobloknot;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Add_AZS extends ActionBarActivity {
    EditText etData, etSuma, etPrice, etCount, etProbeg;
    Button btnAdd_azs, btnBack;
    DataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__azs);

        etData = (EditText)findViewById(R.id.etData1);
        etSuma = (EditText)findViewById(R.id.etSuma1);
        etPrice = (EditText)findViewById(R.id.etPrice);
        etCount = (EditText)findViewById(R.id.etCount);
        etProbeg = (EditText)findViewById(R.id.etProbeg);
        btnAdd_azs = (Button)findViewById(R.id.btnAdd_azs);
        btnBack = (Button)findViewById(R.id.btnBack1);

        database = new DataBase(this);
    }


    public void onClickAdd_azs(View view) {

        String data = etData.getText().toString();
        String suma = etSuma.getText().toString();
        String price = etPrice.getText().toString();
        String count = etCount.getText().toString();
        String probeg = etProbeg.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put("data", data);
        cv.put("suma", suma);
        cv.put("price", price);
        cv.put("count", count);
        cv.put("probeg", probeg);

        SQLiteDatabase db = database.dbHelper.getWritableDatabase();
        db.insert("oil", null, cv);
        Toast toast = new Toast(this);
        toast.makeText(getApplicationContext(), "Запись добавлена", Toast.LENGTH_SHORT).show();
        etData.setText("");
        etSuma.setText("");
        etPrice.setText("");
        etCount.setText("");
        etProbeg.setText("");
    }

    public void onClickBack(View view) {
        finish();
    }
}
