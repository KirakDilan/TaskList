package com.example.mytasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Impressum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impressum);

        TextView impressumlogo = findViewById(R.id.impressumlogo);
        Button btnback3 = findViewById(R.id.btnback3);

        //Back to the Settings
        btnback3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Impressum.this, Settings.class);
                startActivity(intent);
            }
        });

    }
}