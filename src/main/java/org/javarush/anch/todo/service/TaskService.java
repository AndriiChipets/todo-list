package org.javarush.anch.todo.service;

import org.javarush.anch.todo.domain.Task;

import java.util.List;

public interface TaskService {
    void addTask(Task task);

    Task getTaskById(int id);

    List<Task> getAllTasks();

    void deleteTaskById(int id);

}
