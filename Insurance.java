package com.example.loginsignupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insurance extends AppCompatActivity {
    Button buttonSubmit;
    String emailStr= "";
    DatabaseHelper1 db = new DatabaseHelper1(this);
    Cursor cr;
    EditText editViewFirstName,editViewLastName,editViewEmailId,editViewPassword,editViewConfirmPassword,editViewMobileNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);
        Intent intent = getIntent();
        emailStr =  intent.getStringExtra("emailStr");
        Log.e("emailStr==","====emailStr=22==="+emailStr);
        editViewFirstName = (EditText)findViewById(R.id.editViewFirstName);
        editViewEmailId = (EditText)findViewById(R.id.editViewEmailId);
        editViewPassword = (EditText)findViewById(R.id.editViewPassword);
        editViewConfirmPassword = (EditText)findViewById(R.id.editViewConfirmPassword);
        editViewMobileNo = (EditText) findViewById(R.id.editViewMobileNo);

        cr = db.getAllDataById(emailStr);
        while (cr.moveToNext())
        {
            Log.e("Tag","====0===>"+cr.getString(0));
            Log.e("Tag","====1===>"+cr.getString(1));
            Log.e("Tag","====2===>"+cr.getString(2));
            Log.e("Tag","====3===>"+cr.getString(3));
            Log.e("Tag","====4===>"+cr.getString(4));
            Log.e("Tag","====5===>"+cr.getString(5));
            Log.e("Tag","====6===>"+cr.getString(6));
            editViewFirstName.setText(cr.getString(1));
            editViewEmailId.setText(cr.getString(3));
            editViewPassword.setText(cr.getString(4));
            editViewConfirmPassword.setText(cr.getString(5));
            editViewMobileNo.setText(cr.getString(6));

        }
        buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean insertdata = db.updateTeacherData(editViewFirstName.getText().toString().trim(),emailStr,editViewEmailId.getText().toString().trim(),editViewPassword.getText().toString().trim(),editViewConfirmPassword.getText().toString().trim(),editViewMobileNo.getText().toString());
                Toast.makeText(Insurance.this, "Data Saved", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
