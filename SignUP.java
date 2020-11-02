package com.example.loginsignupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUP extends AppCompatActivity {

    Button buttonSubmit,buttonNext,buttonCal;
    EditText editViewFirstName,editViewLastName,editViewPassword,editViewEmailId;
    DatabaseHelper1 db = new DatabaseHelper1(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_u_p);

        buttonSubmit = (Button)findViewById(R.id.buttonSubmit);

        editViewFirstName = (EditText)findViewById(R.id.editViewFirstName);
        editViewLastName = (EditText)findViewById(R.id.editViewLastName);
        editViewPassword = (EditText)findViewById(R.id.editViewPassword);
        editViewEmailId = (EditText)findViewById(R.id.editViewEmailId);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editViewFirstName.getText().toString().trim().length() == 0 && editViewLastName.getText().toString().trim().length() == 0 && editViewPassword.getText().toString().trim().length() == 0 && editViewEmailId.getText().toString().trim().length() == 0)
                {
                    Toast.makeText(SignUP.this, "Please enter the information", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    postDataToSQLite();
                }
            }
        });




    }

    private void postDataToSQLite() {

        boolean insertdata = db.insertData1(editViewFirstName.getText().toString().trim(),editViewLastName.getText().toString().trim(),editViewPassword.getText().toString().trim(),editViewEmailId.getText().toString().trim(),"","");
        if(insertdata == true)
        {
            Toast.makeText(SignUP.this, "Data Saved ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignUP.this,MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(SignUP.this, "Data Not Saved", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Register Successful", Toast.LENGTH_SHORT).show();

    }
}
