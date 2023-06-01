package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication1.employeeActivities.EmpListActivity;

public class HealthActivity extends AppCompatActivity {



    CardView cvCreateEmp, cvListEmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        cvCreateEmp =findViewById(R.id.cardCreateEmp);
        cvListEmp =findViewById(R.id.cardListEmp);


        cvCreateEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HealthActivity.this, CreateEmployeeActivity.class));

                Toast.makeText(HealthActivity.this, "Create Employee card clicked!!", Toast.LENGTH_SHORT).show();
            }
        });
        cvListEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthActivity.this, EmpListActivity.class));

                Toast.makeText(HealthActivity.this, "List Employee card clicked!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}