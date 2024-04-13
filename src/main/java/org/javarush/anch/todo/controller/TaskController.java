package org.javarush.anch.todo.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.anch.todo.dto.TaskInfo;
import org.javarush.anch.todo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public String tasks(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {

        return "tasks";
    }

    @PostMapping("/{id}")
    public void edit(Model model,
                     @PathVariable Integer id,
                     @RequestBody TaskInfo info) {

    }

    @PostMapping("/")
    public void add(Model model,
                    @RequestBody TaskInfo info) {

    }

    @PostMapping("/{id}")
    public String delete(Model model,
                         @PathVariable Integer id) {

        return "tasks";
    }
}
