package com.example.mytasklist;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Login variables
        TextView logo = findViewById(R.id.logo);
        TextView inputUsername = findViewById(R.id.inputUsername);
        TextView inputPassword = findViewById(R.id.inputPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView change = findViewById(R.id.change);
        DBHelper DB = new DBHelper(this);



        //compares the data with the database
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();

                if(user.equals("")||password.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpassword = DB.checkusernamepassword(user, password);
                    if(checkuserpassword==true) {
                        Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, ToDoListe.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        //Change to the Registration-Page
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);

            }
        });


    }
}




