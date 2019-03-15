package com.cucumber.framework.implementation;

public class TodoList {

    int totalTaskCount;
    int finishedTaskCount;

    public TodoList() {
        totalTaskCount = finishedTaskCount = 0;
    }

    public int getTotalTaskCount() {
        return totalTaskCount;
    }

    public void setTotalTaskCount(int count) {
        totalTaskCount = count;
    }

    public void finishTask(int count) {
        finishedTaskCount = count;
    }

    public int getRestTasksCount() {
        return totalTaskCount - finishedTaskCount;
    }
}
