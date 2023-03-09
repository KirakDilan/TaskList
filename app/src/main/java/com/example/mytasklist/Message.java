package com.example.mytasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        TextView datelogo = findViewById(R.id.datelogo);
        Button btnback2 = findViewById(R.id.btnback2);
        Switch switch1 = findViewById(R.id.switch1);
        TextView infoText = findViewById(R.id.infoText);


        //save the Switch change
        SharedPreferences sharedPreferences = getSharedPreferences("save"
                , MODE_PRIVATE);
        switch1.setChecked(sharedPreferences.getBoolean("value", true));

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch1.isChecked()) {
                    //When switch checked
                    SharedPreferences.Editor editor = getSharedPreferences("save"
                            , MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    switch1.setChecked(true);
                } else {
                    //when switch unchecked
                    SharedPreferences.Editor editor = getSharedPreferences("save"
                            , MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    switch1.setChecked(false);
                }
            }
        });


        //Back to the Settings
        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Message.this, Settings.class);
                startActivity(intent);
            }
        });
    }

}