package com.example.loginsignupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonLogin,buttonRegister;
    EditText editViewFirstName,editViewLastName;
    DatabaseHelper1 db = new DatabaseHelper1(this);
    Cursor cr;
    String emailStr = null;
    String nameStr = null;

    String adminEmail = "admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initLoginButton();

        editViewFirstName = (EditText)findViewById(R.id.editViewFirstName);
        editViewLastName = (EditText)findViewById(R.id.editViewLastName);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDataToSQLite();
            }
        });
        buttonRegister = (Button)findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SignUP.class);
                startActivity(intent);
            }
        });
    }

    private void postDataToSQLite()
    {
        cr = db.getAllDataById(editViewFirstName.getText().toString().trim());
        while (cr.moveToNext())
        {
            Log.e("Tag","=======>"+cr.getString(2));
            Toast.makeText(this, " Successful==="+cr.getString(2), Toast.LENGTH_SHORT).show();
            emailStr = cr.getString(2);
            nameStr = cr.getString(1);
            Log.e("Tag","==name=====>"+cr.getString(1));

        }

        try {

             if(editViewFirstName.getText().toString().trim().length() ==0 && editViewLastName.getText().toString().length()==0)
             {
                 Toast.makeText(MainActivity.this, "Please enter the information", Toast.LENGTH_SHORT).show();
             }
             else
             {
                 if(adminEmail.equals(editViewFirstName.getText().toString().trim()))
                 {
                     Log.e("T","111111111111111111111");
                     Toast.makeText(MainActivity.this, "Successfully Credentials", Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(MainActivity.this,DashAdmin.class);
                     intent.putExtra("name","Admin");
                     startActivity(intent);
                 }

                 else if(emailStr.equals(editViewFirstName.getText().toString().trim()))
                 {
                     Toast.makeText(MainActivity.this, "Successfully Credentials", Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(MainActivity.this,DashUser.class);
                     intent.putExtra("name",nameStr);
                     intent.putExtra("emailStr",emailStr);
                     startActivity(intent);
                 }
                 else
                 {
                     Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                 }

             }

        }
        catch(Exception e)
        {
            Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

        }
      //  boolean insertdata = db.insertData(editViewFirstName.getText().toString().trim(),editViewLastName.getText().toString().trim());

        //Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

    }

/**
    private void initLoginButton(){
        Button login = findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
**/
}