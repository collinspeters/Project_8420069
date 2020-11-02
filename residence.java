package com.example.loginsignupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class residence extends AppCompatActivity {
    EditText editViewFirstName,editViewLastName,editViewAddress,editViewDOB,editViewlicenseType;
    Button buttonLic;
    DatabaseHelper1 db = new DatabaseHelper1(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residence);

        editViewFirstName = (EditText)findViewById(R.id.editViewFirstName);
        editViewLastName = (EditText)findViewById(R.id.editViewLastName);
        editViewAddress = (EditText)findViewById(R.id.editViewAddress);
        editViewDOB = (EditText)findViewById(R.id.editViewDOB);

        buttonLic = (Button)findViewById(R.id.buttonLic);

        buttonLic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDataToSQLite();
            }
        });

    }

    private void postDataToSQLite() {

        boolean insertdata = db.insertDataResidence(editViewFirstName.getText().toString().trim(),editViewLastName.getText().toString().trim(),editViewAddress.getText().toString().trim(),editViewDOB.getText().toString().trim());
        if(insertdata == true)
        {
            clear();
            Toast.makeText(residence.this, "Data Saved ", Toast.LENGTH_SHORT).show();

        }
        else
        {
            clear();
            Toast.makeText(residence.this, "Data Not Saved", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Data saved Successful", Toast.LENGTH_SHORT).show();

    }

    public void clear()
    {

        editViewFirstName.getText().clear();
        editViewLastName.getText().clear();
        editViewAddress.getText().clear();
        editViewDOB.getText().clear();
    }

}
