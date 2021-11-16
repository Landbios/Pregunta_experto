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

public class AddCapital extends AppCompatActivity {

    private EditText et2;
    private TextView VC2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_capital);

        VC2 = (TextView) findViewById(R.id.View_Country);
        et2 = (EditText) findViewById(R.id.enter_capital);
    }

    public void ReturnButton (View view) {

        Intent ReturnButton = new Intent(this, MainActivity.class);
        startActivity(ReturnButton);

    }

    public void AddButton (View view) {

        Intent AddButton = new Intent(this, AddActivity.class);
        startActivity(AddButton);

    }

    public void consulta2(View view){
        MyDatabaseHelper myDB = new MyDatabaseHelper(AddCapital.this);
        SQLiteDatabase db = myDB.getWritableDatabase();

        String capital = et2.getText().toString();

        if(!capital.isEmpty()){
            Cursor fila = db.rawQuery("select Country from my_countries where Capital ='"+capital+"'", null);

            if(fila.moveToFirst()){
                VC2.setText(fila.getString(0));
                db.close();
            }else{
                Toast.makeText(this, "No existe esa capital en mi base de datos ve a agregarlo", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debes introducir un pais", Toast.LENGTH_SHORT).show();
            db.close();
        }

    }
}