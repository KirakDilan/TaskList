package com.example.mytasklist;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskListAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    TaskManager taskManager;

    public TaskListAdapter(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.task_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskManager.getTaskList().get(position);
        holder.checkBox.setText(task.getName());
        holder.checkBox.setChecked(false);
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> onCheckedChange(isChecked,task, holder.getLayoutPosition()));
    }

    //as soon as the checkbox is clicked, this task is deleted
    protected void onCheckedChange(boolean isChecked,Task task, int position) {
        if(isChecked) {
            taskManager.removeTask(task);
            notifyItemRemoved(position);

        }
    }

    @Override
    public int getItemCount() {
        return taskManager.getTaskCount();
    }
}
