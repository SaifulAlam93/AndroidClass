package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1={
            {"Doctor Name : Abdullah", "Hospital Address : Mog-bazaar", "Exp : 5yrs", "Mobile No:0171122334455", "600"},
            {"Doctor Name : Abdullah-22", "Hospital Address : Mog-bazaar-22", "Exp : 5yrs-22", "Mobile No:0171122334422", "200"},
            {"Doctor Name : Abdullah-33", "Hospital Address : Mog-bazaar-33", "Exp : 5yrs-33", "Mobile No:0171122334433", "300"},
            {"Doctor Name : Abdullah-44", "Hospital Address : Mog-bazaar-44", "Exp : 5yrs-44", "Mobile No:0171122334444", "400"}
    };
    private String[][] doctor_details2={
            {"Doctor Name : Abdullah", "Hospital Address : Mog-bazaar", "Exp : 5yrs", "Mobile No:0171122334455", "600"},
            {"Doctor Name : Abdullah-22", "Hospital Address : Mog-bazaar-22", "Exp : 5yrs-22", "Mobile No:0171122334422", "200"},
            {"Doctor Name : Abdullah-33", "Hospital Address : Mog-bazaar-33", "Exp : 5yrs-33", "Mobile No:0171122334433", "300"},
            {"Doctor Name : Abdullah-44", "Hospital Address : Mog-bazaar-44", "Exp : 5yrs-44", "Mobile No:0171122334444", "400"}
    };    private String[][] doctor_details3={
            {"Doctor Name : Abdullah", "Hospital Address : Mog-bazaar", "Exp : 5yrs", "Mobile No:0171122334455", "600"},
            {"Doctor Name : Abdullah-22", "Hospital Address : Mog-bazaar-22", "Exp : 5yrs-22", "Mobile No:0171122334422", "200"},
            {"Doctor Name : Abdullah-33", "Hospital Address : Mog-bazaar-33", "Exp : 5yrs-33", "Mobile No:0171122334433", "300"},
            {"Doctor Name : Abdullah-44", "Hospital Address : Mog-bazaar-44", "Exp : 5yrs-44", "Mobile No:0171122334444", "400"}
    };    private String[][] doctor_details4={
            {"Doctor Name : Abdullah", "Hospital Address : Mog-bazaar", "Exp : 5yrs", "Mobile No:0171122334455", "600"},
            {"Doctor Name : Abdullah-22", "Hospital Address : Mog-bazaar-22", "Exp : 5yrs-22", "Mobile No:0171122334422", "200"},
            {"Doctor Name : Abdullah-33", "Hospital Address : Mog-bazaar-33", "Exp : 5yrs-33", "Mobile No:0171122334433", "300"},
            {"Doctor Name : Abdullah-44", "Hospital Address : Mog-bazaar-44", "Exp : 5yrs-44", "Mobile No:0171122334444", "400"}
    };    private String[][] doctor_details5={
            {"Doctor Name : Abdullah", "Hospital Address : Mog-bazaar", "Exp : 5yrs", "Mobile No:0171122334455", "600"},
            {"Doctor Name : Abdullah-22", "Hospital Address : Mog-bazaar-22", "Exp : 5yrs-22", "Mobile No:0171122334422", "200"},
            {"Doctor Name : Abdullah-33", "Hospital Address : Mog-bazaar-33", "Exp : 5yrs-33", "Mobile No:0171122334433", "300"},
            {"Doctor Name : Abdullah-44", "Hospital Address : Mog-bazaar-44", "Exp : 5yrs-44", "Mobile No:0171122334444", "400"}
    };

    TextView tv;
    Button btn;


    private String[][] doctor_details={ };
    HashMap<String ,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);



        if(title.compareTo("Family Physician")==0){
            doctor_details = doctor_details1;
        } else if (title.compareTo("Family Dietician")==0) {
            doctor_details = doctor_details2;
        }else if (title.compareTo("Family Dentist")==0) {
            doctor_details = doctor_details3;
        }else if (title.compareTo("Family Surgeon")==0) {
            doctor_details = doctor_details4;
        }else {
            doctor_details = doctor_details5;
        }

        list = new ArrayList<>();
        for (int i = 0; i < doctor_details.length; i++) {
            item= new HashMap<>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");

            list.add(item);

        }


        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity((new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class)));
            }
        });

        sa = new SimpleAdapter(this,
                list,
                R.layout.multy_line,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e });
        ListView lv = findViewById(R.id.listViewDD);
        lv.setAdapter(sa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppiontmentActivity.class);
              it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);


            }
        });

    }

}

