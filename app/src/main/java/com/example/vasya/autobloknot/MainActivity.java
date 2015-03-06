package com.example.vasya.autobloknot;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    Button btnAdd_AZS, btnAdd_STO, btnShow_AZS, btnShow_STO, btnOil_calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd_AZS = (Button)findViewById(R.id.btnAdd_AZS);
        btnAdd_STO = (Button)findViewById(R.id.btnAdd_STO);
        btnShow_AZS = (Button)findViewById(R.id.btnShow_AZS);
        btnShow_STO = (Button)findViewById(R.id.btnShow_STO);
        btnOil_calc = (Button)findViewById(R.id.btnOil_calc);
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
        if (id == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickMain(View view) {
        switch (view.getId()){
            case R.id.btnAdd_AZS:
                startActivity(new Intent(getApplicationContext(), Add_AZS.class));
                break;
            case R.id.btnAdd_STO:
                startActivity(new Intent(getApplicationContext(), Add_STO.class));
                break;
            case R.id.btnShow_AZS:
                startActivity(new Intent(getApplicationContext(), Show_AZS.class));
                break;
            case R.id.btnShow_STO:
                startActivity(new Intent(getApplicationContext(), Show_STO.class));
                break;
            case R.id.btnOil_calc:
                startActivity(new Intent(getApplicationContext(), Oil_calc.class));
                break;
        }
    }

    public void onClickExit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выход")
                .setMessage("Вы действительно хотите выйти")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
