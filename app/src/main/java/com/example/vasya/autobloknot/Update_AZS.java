package com.example.vasya.autobloknot;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Update_AZS extends ActionBarActivity {
    EditText etData, etSuma, etPrice, etCount, etProbeg;
    Button btnUpdate_azs, btnBack;
    DataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__azs);

        etData = (EditText)findViewById(R.id.etData1);
        etSuma = (EditText)findViewById(R.id.etSuma1);
        etPrice = (EditText)findViewById(R.id.etPrice);
        etCount = (EditText)findViewById(R.id.etCount);
        etProbeg = (EditText)findViewById(R.id.etProbeg);
        btnUpdate_azs = (Button)findViewById(R.id.btnUpdate_azs);
        btnBack = (Button)findViewById(R.id.btnBack1);

        database = new DataBase(this);
    }

    public void onClickUpdate_azs(View view) {
        String data = etData.getText().toString();
        String suma = etSuma.getText().toString();
        String price = etPrice.getText().toString();
        String count = etCount.getText().toString();
        String probeg = etProbeg.getText().toString();

        String id = getIntent().getStringExtra("id");

        if(data.trim().equals("")||suma.trim().equals("")||price.trim().equals("")||count.trim().equals("")||probeg.trim().equals("")){
            Toast.makeText(this, "Для обновления записи нужно заполнить все поля", Toast.LENGTH_LONG).show();
        } else {

            ContentValues cv = new ContentValues();
            cv.put("data", data);
            cv.put("suma", suma);
            cv.put("price", price);
            cv.put("count", count);
            cv.put("probeg", probeg);

            SQLiteDatabase db = database.dbHelper.getWritableDatabase();
            db.update("oil", cv, "_id = " + id, null);
            Toast.makeText(this, "Запись обновлена", Toast.LENGTH_SHORT).show();
            etData.setText("");
            etSuma.setText("");
            etPrice.setText("");
            etCount.setText("");
            etProbeg.setText("");
        }
    }

    public void onClickBack(View view) {
        finish();
    }
}
