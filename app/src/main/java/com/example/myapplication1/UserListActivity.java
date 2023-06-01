package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserListActivity extends AppCompatActivity {

    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        Database db = new Database(getApplicationContext(), "healthcare", null, 1);
        list = new ArrayList<>();
        list = db.getEmployees();

//        list = list2;
        System.out.println(list);
        System.out.println("-------------------------");

//        sa = new SimpleAdapter((Context) this,
//                list,
//                R.layout.user_list,
//                new String[]{"id","userName","email","password"},
//                new int[]{R.id.line_id, R.id.line_c, R.id.line_d, R.id.line_e });

        sa = new SimpleAdapter(this,
                list,
                R.layout.user_list,
                new String[]{"id", "userName", "email", "password"},
                new int[]{R.id.line_id, R.id.line_c, R.id.line_d, R.id.line_e}
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ImageView editBtn = v.findViewById(R.id.emp_edit_btn);
                ImageView delBtn = v.findViewById(R.id.emp_del_btn);


                editBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println(position);
                        HashMap<String, String> user;
                        try {
                            System.out.println(v.findViewById(R.id.line_c).toString());

                            user = (HashMap<String, String>) list.get(position);
                            System.out.println(user);
                        } catch (Exception e) {
                        }

                        System.out.println("EDITTTTTTTTTTTTTTTTTTTTTTTTTT");
//                Intent intent = new Intent(context, AddEmployeeActivity.class);
//                intent.putExtra("empId", employee.getId());
//                intent.putExtra("empName", employee.getName());
//                intent.putExtra("empEmail", employee.getEmail());
//                intent.putExtra("empPrice", employee.getPrice());
//                intent.putExtra("empQuantity", employee.getQuantity());
//                context.startActivity(intent);
                    }
                });

                delBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        System.out.println("Viewwwwwwwwwwwwwwwwwwwwwwwwwww");

//                boolean deleted = EmployeeDao.deleteEmployee(employee.getId());
//                if (deleted) {
//                    employees.remove(i);
//                    notifyDataSetChanged();
//                }
//                String message = deleted ? "Successfully deleted" : "Failed to delete";
//                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    }
                });


                return v;
            }


        };

        ListView lv = findViewById(R.id.listViewUD);
        lv.setAdapter(sa);
//        ImageButton editBtn = lv.findViewById(R.id.emp_edit_btn);
//        ImageButton delBtn = lv.findViewById(R.id.emp_del_btn);
//
//        editBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                System.out.println("EDITTTTTTTTTTTTTTTTTTTTTTTTTT");
////                Intent intent = new Intent(context, AddEmployeeActivity.class);
////                intent.putExtra("empId", employee.getId());
////                intent.putExtra("empName", employee.getName());
////                intent.putExtra("empEmail", employee.getEmail());
////                intent.putExtra("empPrice", employee.getPrice());
////                intent.putExtra("empQuantity", employee.getQuantity());
////                context.startActivity(intent);
//            }
//        });
//
//        delBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                System.out.println("Viewwwwwwwwwwwwwwwwwwwwwwwwwww");
//
////                boolean deleted = EmployeeDao.deleteEmployee(employee.getId());
////                if (deleted) {
////                    employees.remove(i);
////                    notifyDataSetChanged();
////                }
////                String message = deleted ? "Successfully deleted" : "Failed to delete";
////                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}