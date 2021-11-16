package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCountry extends AppCompatActivity {

    private EditText et1;
    private TextView VC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);


        VC = (TextView) findViewById(R.id.View_Capital);
        et1 = (EditText) findViewById(R.id.enter_country);
    }

    public void ReturnButton (View view) {

        Intent ReturnButton = new Intent(this, MainActivity.class);
        startActivity(ReturnButton);

    }

    public void AddButton (View view) {

        Intent AddButton = new Intent(this, AddActivity.class);
        startActivity(AddButton);

    }

    public void consulta(View view){
        MyDatabaseHelper myDB = new MyDatabaseHelper(AddCountry.this);
        SQLiteDatabase db = myDB.getWritableDatabase();

        String pais = et1.getText().toString();

        if(!pais.isEmpty()){
            Cursor fila = db.rawQuery("select Capital from my_countries where Country ='"+pais+"'", null);
            if(fila.moveToFirst()){
                VC.setText(fila.getString(0));
                db.close();
            }else{
                Toast.makeText(this, "No existe ese pais en mi base de datos ve a agregarlo", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debes introducir un pais", Toast.LENGTH_SHORT).show();
            db.close();
        }

    }
}