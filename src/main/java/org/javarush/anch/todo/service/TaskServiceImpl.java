package org.javarush.anch.todo.service;

import lombok.RequiredArgsConstructor;
import org.javarush.anch.todo.domain.Status;
import org.javarush.anch.todo.domain.Task;
import org.javarush.anch.todo.dao.TaskDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    @Override
    public List<Task> getAll(int offset, int limit) {
        return taskDAO.getAll(offset, limit);
    }

    @Override
    public int getAllCount() {
        return taskDAO.getAllCount();
    }

    @Transactional
    @Override
    public Task edit(int id, String description, Status status) {
        Task task = taskDAO.getById(id);
        if (isNull(task)) {
            throw new RuntimeException("Not found");
        }
        task.setDescription(description);
        task.setStatus(status);
        taskDAO.saveOrUpdate(task);
        return task;
    }

    @Override
    public Task create(String description, Status status) {
        Task task = Task.builder().withDescription(description).withStatus(status).build();
        taskDAO.saveOrUpdate(task);
        return task;
    }

    @Transactional
    @Override
    public void delete(int id) {
        Task task = taskDAO.getById(id);
        if (isNull(task)) {
            throw new RuntimeException("Not found");
        }
        taskDAO.delete(task);
    }

}
