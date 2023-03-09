package com.example.mytasklist;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //Registration variables
        TextView logo2 = findViewById(R.id.logo2);
        TextView inputUsername = findViewById(R.id.inputUsername);
        TextView inputEmail = findViewById(R.id.inputEmail);
        TextView inputPassword = findViewById(R.id.inputPassword);
        TextView inputRepeat = findViewById(R.id.inputRepeat);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView change2 = findViewById(R.id.change2);
        DBHelper DB = new DBHelper(this);


        //inserts the data from the registry into the database after checking the conditions
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();
                String repeat = inputRepeat.getText().toString();
                String Email = inputEmail.getText().toString();

                if (user.equals("") || password.equals("") || repeat.equals(""))
                    Toast.makeText(Registration.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (password.equals(repeat)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, password);
                            if (insert == true) {
                                Toast.makeText(Registration.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Registration.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Registration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Registration.this, "User already exists! Please choose a other one!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Registration.this, "Passwords are not equals", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });


        //Back to the Home-Page
        change2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Registration.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
