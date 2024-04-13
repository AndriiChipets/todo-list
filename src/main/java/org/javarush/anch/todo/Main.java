package org.javarush.anch.todo;


import org.javarush.anch.todo.config.AppConfig;
import org.javarush.anch.todo.domain.Task;
import org.javarush.anch.todo.service.TaskService;
import org.javarush.anch.todo.service.TaskServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskService taskService = applicationContext.getBean(TaskServiceImpl.class);
        List<Task> tasks = taskService.getAllTasks();
        tasks.forEach(System.out::println);
    }
}
