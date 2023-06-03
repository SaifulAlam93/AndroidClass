package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText edUserName, edPassword;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        edUserName = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);
        Database db = new Database(getApplicationContext(), "healthcare", null,1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = edUserName.getText().toString();
                String password = edPassword.getText().toString();

                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
//                startActivity(new Intent(LoginActivity.this, NavigationActivity.class));

//                if (userName.length()==0 || password.length()==0){
//                    Toast.makeText(getApplicationContext(),"Please Fill All The Data Field.",Toast.LENGTH_SHORT).show();
//                }else {
//                    if (db.login(userName,password)==1){
//                        Toast.makeText(getApplicationContext(),"Login Success Tex.",Toast.LENGTH_SHORT).show();
//                        SharedPreferences preferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = preferences.edit();
//                        editor.putString("usernamr",userName);
//                        editor.apply();
//                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
//                    }else {
//                        Toast.makeText(getApplicationContext(),"Wrong Password and UserName..",Toast.LENGTH_SHORT).show();
//                    }
//                }          ;
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}