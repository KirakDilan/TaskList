package com.example.mytasklist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

class TaskListTouchCallback extends ItemTouchHelper.SimpleCallback {

    TaskManager taskManager;

    //tasks can be sorted in different order according to need
    public TaskListTouchCallback(TaskManager taskManager) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0);
        this.taskManager = taskManager;
    }

    //Move the Task
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        int oldPosition = viewHolder.getAbsoluteAdapterPosition();
        int newPosition = target.getAbsoluteAdapterPosition();
        taskManager.moveTask(oldPosition, newPosition);
        recyclerView.getAdapter().notifyItemMoved(oldPosition, newPosition);
        return true;
    }

    //we don't need this method
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
