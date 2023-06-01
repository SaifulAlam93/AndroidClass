package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication1.entity.Employee;

import java.util.Calendar;

public class CreateEmployeeActivity extends AppCompatActivity {



    EditText edEmpName, edEmpAddress, edEmpSalary, edEmail, edDate;
    Button btn;
    Spinner spinnerDepartment;
    TextView tv;

    DatePickerDialog datePickerDialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employee);


        edEmpName = findViewById(R.id.editTextEmpName);
        edEmpAddress = findViewById(R.id.editTextEmpAddress);
        edEmpSalary = findViewById(R.id.editTextEmpSalary);
        edEmail = findViewById(R.id.editTextEmpEmail);
        edDate = findViewById(R.id.date);
//        spinnerDepartment = sqLiteCreateFragment.spinnerDepartment;
        spinnerDepartment = findViewById(R.id.spinnerEmpDepartment);

        btn = findViewById(R.id.buttonCreateEmp);
        tv = findViewById(R.id.textViewBack);


        Database db = new Database(getApplicationContext(), "healthcare", null,1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Navigation.findNavController(view).navigate(R.id.nav_gallery);

                Employee emp = new Employee();
                String name = edEmpName.getText().toString();
                String address = edEmpAddress.getText().toString();
                String salary = edEmpSalary.getText().toString();
                String dep = spinnerDepartment.getSelectedItem().toString();
                String email = edEmail.getText().toString();
                String date = edDate.getText().toString();

                emp.setName(name);
                emp.setAddress(address);
                emp.setSalary(Integer.valueOf(salary));
                emp.setDep(dep);
                emp.setEmail(email);


                db.addNewEmployee(emp);
                Toast.makeText(getApplicationContext(), "date-- " +date, Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), name+" "+address+" "+salary+" "+dep+" "+email+" ", Toast.LENGTH_SHORT).show();
//                Database db = new Database(getContext(), "healthcare", null,1);



            }
        });

        edDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(CreateEmployeeActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                edDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

    }
}