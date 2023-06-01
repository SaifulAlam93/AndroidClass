package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppiontmentActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4;
    TextView tv;
    Button dateButton, timeButton, btnReg, btnBack;

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appiontment);

        tv = findViewById(R.id.textViewAppTitle);
        ed1 = findViewById(R.id.editTextAppUsername);
        ed2 = findViewById(R.id.editTextAppAddress);
        ed3 = findViewById(R.id.editTextAppContractNum);
        ed4 = findViewById(R.id.editTextAppConsultantFees);

        dateButton = findViewById(R.id.buttonAppDate);
        timeButton = findViewById(R.id.buttonAppDate2);

        btnReg = findViewById(R.id.buttonReg);
        btnBack = findViewById(R.id.buttonBack);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);


        Intent it = getIntent();

        String title = it.getStringExtra("text1");
        String userName = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contract = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(userName);
        ed2.setText(address);
        ed3.setText(contract);
        ed4.setText("Cons Fees: "+fees+"/-");

        //Date Picker

        initDatePicker();

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        initTimePicker();

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int mon = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;


        datePickerDialog = new DatePickerDialog(this, style, onDateSetListener, year, mon, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);


    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i+":"+i1);

            }
        };
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;


        timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour , mins,true);
//        timePickerDialog.get.setMinDate(cal.getTimeInMillis()+86400000);
    }



}