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


public class Update_STO extends ActionBarActivity {
    Button btnUpdate_sto, btnBack;
    EditText etData, etSuma, etDesc;
    DataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__sto);

        btnUpdate_sto = (Button)findViewById(R.id.btnAdd_sto);
        btnBack = (Button)findViewById(R.id.btnBack1);
        etData = (EditText)findViewById(R.id.etData1);
        etSuma = (EditText)findViewById(R.id.etSuma1);
        etDesc = (EditText)findViewById(R.id.etDesc1);
        database = new DataBase(this);
    }


    public void onClickUpdate_sto(View view) {
        String data = etData.getText().toString();
        String suma = etSuma.getText().toString();
        String desc = etDesc.getText().toString();

        String id = getIntent().getStringExtra("id");

        if(data.trim().equals("")||suma.trim().equals("")||desc.trim().equals("")){
            Toast.makeText(this, "Для обновления записи нужно заполнить все поля", Toast.LENGTH_LONG).show();
        } else {
            ContentValues cv = new ContentValues();
            cv.put("data", data);
            cv.put("suma", suma);
            cv.put("desc", desc);

            SQLiteDatabase db = database.dbHelper.getWritableDatabase();
            db.update("sto", cv, "_id = " + id, null);
            Toast.makeText(this, "Запись обновлена", Toast.LENGTH_SHORT).show();
            etData.setText("");
            etSuma.setText("");
            etDesc.setText("");
        }
    }

    public void onClickBack(View view) {
        finish();
    }
}
