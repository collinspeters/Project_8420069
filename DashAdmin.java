package com.example.loginsignupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashAdmin extends AppCompatActivity {
    TextView name;
    Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_admin);

        name = (TextView)findViewById(R.id.name);
        final Intent intent = getIntent();
        String nameStr = intent.getStringExtra("name");
        name.setText("Welcome "+nameStr);

        view = (Button)findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent1 = new Intent(DashAdmin.this, Select.class);
              startActivity(intent1);
            }
        });
    }
}
