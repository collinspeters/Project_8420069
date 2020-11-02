package com.example.loginsignupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashUser extends AppCompatActivity {
     Button service,license,health,residence1;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_user);

        name = (TextView)findViewById(R.id.name);
        Intent intent = getIntent();
        String nameStr = intent.getStringExtra("name");
        name.setText("Welcome "+nameStr);

        service = (Button)findViewById(R.id.service);
        license = (Button)findViewById(R.id.license);
        health=(Button)findViewById(R.id.health);
        residence1 = (Button)findViewById(R.id.residence);

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent4 = new Intent(DashUser.this, Search.class);
              startActivity(intent4);
            }
        });
        license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(DashUser.this,License.class);
                startActivity(intent1);
            }
        });
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(DashUser.this,Health.class);
                startActivity(intent2);
            }
        });
        residence1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3 = new Intent(DashUser.this, residence.class);
                startActivity(intent3);
            }
        });
    }
}
