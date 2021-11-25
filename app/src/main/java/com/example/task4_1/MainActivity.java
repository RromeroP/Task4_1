package com.example.task4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String[] spinnerList = { "Home", "Work", "Mobile", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter adapterList = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerList);
        adapterList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapterList);

    }

    public void showText(View v) {
        EditText textEdit = findViewById(R.id.textEdit);
        Spinner spinner = findViewById(R.id.spinner);
        String string = "Phone number: " + textEdit.getText().toString() + " - " +
                spinnerList[spinner.getSelectedItemPosition()];
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Se podria hacer aqui el toast en caso de no querer un boton
        //Toast.makeText(getApplicationContext(),spinnerList[i] , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}