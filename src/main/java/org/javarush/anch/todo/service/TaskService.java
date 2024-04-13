package org.javarush.anch.todo.service;

import org.javarush.anch.todo.domain.Status;
import org.javarush.anch.todo.domain.Task;

import java.util.List;

public interface TaskService {

    int getAllCount();

    List<Task> getAll(int offset, int limit);

    Task edit(int id, String description, Status status);

    Task create(String description, Status status);

    void delete(int id);

}
