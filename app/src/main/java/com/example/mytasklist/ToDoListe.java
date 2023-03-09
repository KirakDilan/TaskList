package com.example.mytasklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;
import android.widget.Toast;


public class ToDoListe extends AppCompatActivity {

    EditText newtaskEditText;
    ImageView sendButton;
    TaskManager taskManager;
    RecyclerView recyclerView;
    ImageView btnsignout;
    ImageView btnsettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_liste);
        taskManager = new TaskManager(this);
        initViews();
        initClickListeners();

    }
    //variables from the ToDo-Liste
    protected void initViews() {
        newtaskEditText = findViewById(R.id.newtask);
        sendButton = findViewById(R.id.btnsend);
        btnsignout = findViewById(R.id.btnsignout);
        btnsettings = findViewById(R.id.btnsettings);
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TaskListAdapter(taskManager));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new TaskListTouchCallback(taskManager));
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    protected void initClickListeners() {
        //after the button has been pressed, the task is added to the list
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTaskName = newtaskEditText.getText().toString();
                if(newTaskName.length() > 0) {
                    Task task = new Task();
                    task.setName(newTaskName);
                    taskManager.addTask(task);
                    recyclerView.getAdapter().notifyItemInserted(taskManager.getTaskCount() - 1);
                    newtaskEditText.getText().clear();
                    Log.d("Checkliste", "Neue Aufgabe: " + newTaskName);
                } else {
                    Toast.makeText(ToDoListe.this, " Please add a new Task ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Change to the Login-Page
        btnsignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ToDoListe.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Change to the Settings
        btnsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ToDoListe.this, Settings.class);
                startActivity(intent);
            }
        });

    }

}