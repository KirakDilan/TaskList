package com.example.mytasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView settingslogo = findViewById(R.id.settingslogo);
        Button btnback = findViewById(R.id.btnback);
        Button btndatum = findViewById(R.id.btndatum);
        Button btnimpressum = findViewById(R.id.btnimpressum);


        //Back to the todo-liste
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Settings.this, ToDoListe.class);
                startActivity(intent);
            }
        });

        //Change to the Message
        btndatum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Settings.this, Message.class);
                startActivity(intent);
            }
        });

        //Change to the Impressum
        btnimpressum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Settings.this, Impressum.class);
                startActivity(intent);
            }
        });

    }
}