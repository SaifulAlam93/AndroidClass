package com.example.myapplication1;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.myapplication1.entity.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public Database(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//
//
//    }

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "coursedb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "users";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String USER_NAME_COL = "userName";

    // below variable id for our course duration column.
    private static final String PASSWORD_COL = "password";

    // below variable for our course description column.
    private static final String EMAIL_COL = "description";

    // below variable is for our course tracks column.
    private static final String TRACKS_COL = "tracks";


    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";

        String queryEmployee =
                "CREATE TABLE EMPLOYEE ( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, ADDRESS TEXT, SALARY INTEGER,  DEP TEXT )";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
        db.execSQL(queryEmployee);

    }

    public void addNewEmployee(Employee emp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("NAME", emp.getName());
        values.put("ADDRESS", emp.getAddress());
        values.put("SALARY", emp.getSalary());
        values.put("EMAIL", emp.getEmail());
        values.put("DEP", emp.getDep());

        db.insert("EMPLOYEE", null, values);
        db.close();
    }



    public ArrayList<HashMap<String, String>> getAllEmployees() {

        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from EMPLOYEE ", null);

        ArrayList<HashMap<String, String>> employeeList = new ArrayList<>(c.getCount());
        HashMap<String, String> employee;
        if (c.moveToFirst()) {

            do {
                employee = new HashMap<>();
                employee.put("ID", c.getString(0));
                employee.put("NAME", c.getString(1));
                employee.put("EMAIL", c.getString(2));
                employee.put("ADDRESS", c.getString(3));
                employee.put("SALARY", c.getString(4));
                employee.put("DEP", c.getString(5));

                employeeList.add(employee);

            } while (c.moveToNext());

        }
        db.close();
        return employeeList;
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String userNAme, String email, String password) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(USER_NAME_COL, userNAme);
        values.put(EMAIL_COL, email);
        values.put(PASSWORD_COL, password);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public int login(String userName, String password) {

        String[] arr = new String[2];
        arr[0] = userName;
        arr[1] = password;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(" select * from users where userName=? and password=? ", arr);
        if (c.moveToFirst()) {
            return 1;
        }
        return 0;
    }

    //
//
//    public static boolean updateEmployee(Product employee) {
//        SQLiteDatabase db = dbHandler.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COL_NAME, employee.getName());
//        values.put(COL_EMAIL, employee.getEmail());
//        values.put(COL_PRICE, employee.getPrice());
//        values.put(COL_QUANTITY, employee.getQuantity());
//        long result = db.update(TBL_NAME, values, "id = ?", new String[]{employee.getId() + ""});
//        db.close();
//        return result > 0;
//    }
//
    public ArrayList<HashMap<String, String>> getEmployees() {
        HashMap<String, String> user;
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from users ", null);

        ArrayList<HashMap<String, String>> userList = new ArrayList<>(c.getCount());

        if (c.moveToFirst()) {

            do {
                user = new HashMap<>();
                user.put("id", c.getString(0));
                user.put("userName", c.getString(1));
                user.put("password", c.getString(2));
                user.put("email", c.getString(3));

                userList.add(user);

            } while (c.moveToNext());

        }
        db.close();
        return userList;
    }


//    public  ArrayList getEmployees() {
//        HashMap<String ,String> user;
//        SQLiteDatabase db = this.getWritableDatabase();
//        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from users ", null);
//
//        ArrayList<User> userList = new ArrayList<>(c.getCount());
//
//        if (c.moveToFirst()){
//
//            do {
// User u = new User(c.getString(1),c.getString(2),c.getString(3));
//
//                userList.add(u);
//
//            } while (c.moveToNext());
//
//        }
//        db.close();
//        return userList;
//    }


//
//    public static List<Product> getEmployees(String param) {
//        if(param == null || param.isEmpty()) return getEmployees();
//        SQLiteDatabase db = dbHandler.getReadableDatabase();
//        String selectCondition = COL_NAME + " like '%" + param + "%'";
//        List<Product> employees = new ArrayList<>();
//        try {
//            Cursor cursor = db.query(TBL_NAME, new String[]{"id", COL_NAME, COL_EMAIL, COL_PRICE, COL_QUANTITY},
//                    selectCondition, null, null, null, null);
//            if (cursor.moveToFirst()) {
//                do {
//                    String name = cursor.getString(1);
//                    String email = cursor.getString(2);
//                    String price = cursor.getString(3);
//                    String quantity = cursor.getString(4);
//
//                    Product employee = new Product(name, email, price, quantity);
//                    employee.setId(cursor.getInt(0));
//                    employees.add(employee);
//                } while (cursor.moveToNext());
//            }
//            db.close();
//        } catch (Exception e) {
//            Log.e("error", e.getMessage());
//        }
//        return employees;
//    }

//
//    public static boolean deleteEmployee(int id) {
//        SQLiteDatabase db = dbHandler.getWritableDatabase();
//        int rowCount = db.delete(TBL_NAME, "id = ?", new String[]{id + ""});
//        db.close();
//        return rowCount > 0;
//    }

}
