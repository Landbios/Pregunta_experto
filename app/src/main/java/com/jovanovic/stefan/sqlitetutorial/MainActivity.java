package com.jovanovic.stefan.sqlitetutorial;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    MyDatabaseHelper myDB;
    ArrayList<String> country_id, country, capital;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        myDB = new MyDatabaseHelper(MainActivity.this);
        country_id = new ArrayList<>();
        country = new ArrayList<>();
        capital = new ArrayList<>();




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void Countrybutton (View view) {

        Intent countrybutton = new Intent(this, AddCountry.class);
        startActivity(countrybutton);

    }

    public void Capitalbutton (View view) {

        Intent capitalbutton = new Intent(this, AddCapital.class);
        startActivity(capitalbutton);

    }


}
