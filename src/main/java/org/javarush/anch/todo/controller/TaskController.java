package org.javarush.anch.todo.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.anch.todo.domain.Task;
import org.javarush.anch.todo.dto.TaskInfo;
import org.javarush.anch.todo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public String tasks(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {

        List<Task> tasks = taskService.getAll((page - 1) * limit, limit);
        model.addAttribute("tasks", tasks);
        model.addAttribute("current_page", page);
        int totalPages = (int) Math.ceil(1.0 * taskService.getAllCount() / limit);
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("page_numbers", pageNumbers);
        }
        return "tasks";
    }

    @PostMapping("/{id}")
    public String edit(Model model,
                       @PathVariable("id") Integer id,
                       @RequestBody TaskInfo info) {
        System.out.println(info);
        System.out.println(id);
        if (isNull(id) || id <= 0) {
            throw new RuntimeException("Invalid id");
        }
        Task task = taskService.edit(id, info.getDescription(), info.getStatus());
        System.out.println(task);
        return tasks(model, 1, 10);
    }

    @PostMapping("/")
    public String add(Model model,
                      @RequestBody TaskInfo info) {
        System.out.println(info);
        Task task = taskService.create(info.getDescription(), info.getStatus());
        System.out.println(task);
        return tasks(model, 1, 10);
    }

    @DeleteMapping("/{id}")
    public String delete(Model model,
                         @PathVariable("id") Integer id) {
        if (isNull(id) || id <= 0) {
            throw new RuntimeException("Invalid id");
        }
        taskService.delete(id);
        return tasks(model, 1, 10);
    }
}
