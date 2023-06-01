package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("usernamr","").toString();
        Toast.makeText(getApplicationContext(),"Welcome "+userName+"!",Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });


        CardView findDoctor = findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class));
            }
        });


        CardView orderList = findViewById(R.id.cardOrderDetails);
        orderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, UserListActivity.class));
            }
        });




        CardView healthArticle = findViewById(R.id.cardHealthDoctor);
        healthArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, HealthActivity.class));
                Toast.makeText(HomeActivity.this, "Hello!! This is Health Activity.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}