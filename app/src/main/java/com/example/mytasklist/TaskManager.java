package com.example.mytasklist;

import android.content.Context;
import java.util.ArrayList;
import com.orhanobut.hawk.Hawk;

public class TaskManager {

    ArrayList<Task> taskList;

    //opens the saved list
    public TaskManager(Context context) {
        Hawk.init(context).build();
        loadTaskList();
    }

    // add new task to the list
    public void addTask(Task task) {
        taskList.add(task);
        saveTaskList();
    }

    // remove task from the list
    public void removeTask(Task task) {
        taskList.remove(task);
        saveTaskList();
    }

    // move task from the old position to the new position
    public void moveTask(int oldPosition, int newPosition) {
        Task task = taskList.get(oldPosition);
        taskList.remove(task);
        taskList.add(newPosition, task);
        saveTaskList();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public int getTaskCount() {
        return taskList.size();
    }

    // save the list so that it is not deleted when the app is switched off
    protected void saveTaskList(){
        Hawk.put("taskList", taskList);

    }
    //create a list if there was no list before
    protected void loadTaskList() {
        taskList = Hawk.get("taskList", new ArrayList<>());

    }

}
