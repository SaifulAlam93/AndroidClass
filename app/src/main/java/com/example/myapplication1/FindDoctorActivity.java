package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);


        CardView exit = findViewById(R.id.cardFdBack);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });

        CardView familyPhysician = findViewById(R.id.cardFDFamilyPhysician);

        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                intent.putExtra("title","Family Physician");
                startActivity(intent);
            }
        });
        CardView cardFDDietician = findViewById(R.id.cardFDDietician);

        cardFDDietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                intent.putExtra("title","Family Dietician");
                startActivity(intent);
            }
        });
        CardView cardDentist = findViewById(R.id.cardDentist);

        cardDentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                intent.putExtra("title","Family Dentist");
                startActivity(intent);
            }
        });

        CardView cardSurgeon = findViewById(R.id.cardSurgeon);

        cardSurgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                intent.putExtra("title","Family Surgeon");
                startActivity(intent);
            }
        });

        CardView cardCardiologists = findViewById(R.id.cardCardiologists);

        cardCardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                intent.putExtra("title","Family Cardiologists");
                startActivity(intent);
            }
        });



    }
}