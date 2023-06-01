package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class DroupDownActivity extends AppCompatActivity {

    String[] items = {"Java", "PHP", "C++", "C#", "Python", "React", "Angular", "Android"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_droup_down);

        autoCompleteTextView = findViewById(R.id.auto_complete_text);
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_item, items);

        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(DroupDownActivity.this, "Itrm: " +item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}