package com.example.vasya.autobloknot;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Add_STO extends ActionBarActivity {
    Button btnAdd_sto, btnBack;
    EditText etData, etSuma, etDesc;
    DataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__sto);

        btnAdd_sto = (Button)findViewById(R.id.btnAdd_sto);
        btnBack = (Button)findViewById(R.id.btnBack1);
        etData = (EditText)findViewById(R.id.etData1);
        etSuma = (EditText)findViewById(R.id.etSuma1);
        etDesc = (EditText)findViewById(R.id.etDesc1);
        database = new DataBase(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickAdd_sto(View view) {
        String data = etData.getText().toString();
        String suma = etSuma.getText().toString();
        String desc = etDesc.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put("data", data);
        cv.put("suma", suma);
        cv.put("desc", desc);

        SQLiteDatabase db = database.dbHelper.getWritableDatabase();
        db.insert("sto", null, cv);
        Toast toast = new Toast(this);
        etData.setText("");
        etSuma.setText("");
        etDesc.setText("");
        toast.makeText(getApplicationContext(), "Запись добавлена", Toast.LENGTH_SHORT).show();
    }

    public void onClickBack(View view) {
        finish();
    }
}
