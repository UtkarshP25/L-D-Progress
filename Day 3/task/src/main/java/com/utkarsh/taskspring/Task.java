package com.utkarsh.taskspring;

public class Task {
    private int id;
    private String description;

    Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
