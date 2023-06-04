package com.example.myapplication1.restApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication1.R;
import com.example.myapplication1.entity.Employee;
import com.example.myapplication1.entity.Student;

import java.util.List;

public class APIMainActivity extends AppCompatActivity {

    Button getBtn;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apimain);

        getBtn = findViewById(R.id.getAll);
        tv = findViewById(R.id.textViewGetAll);


        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                APIRequestDao apiRequest = new APIRequestDao();


                //**Get All Data
//                try {
//                    List<Student> studentList = apiRequest.getList(getApplicationContext());
//                    Toast.makeText(getApplicationContext(), "Length:-" + studentList.size(), Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }


                //**Post Object

                Student student  = new Student();
                student.setName("Bangladesh");
                student.setUsername("Bangladesh");
                student.setPassword("5644 Bangladesh");

//                apiRequest.addStudent(getApplicationContext(),student);

                 //**Update
                student.setId(45574);
//                apiRequest.updateStudent(getApplicationContext(),student);


                //**Delete
                apiRequest.deleteStudent(getApplicationContext(),45574);



            }
        });

    }
}