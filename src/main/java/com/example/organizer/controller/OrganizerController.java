package com.example.organizer.controller;

import com.example.organizer.entity.Status;
import com.example.organizer.entity.Task;
import com.example.organizer.rpository.StatusRepository;
import com.example.organizer.rpository.TaskRepository;
import com.example.organizer.service.StatusService;
import com.example.organizer.service.TaskService;
import com.example.organizer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrganizerController {

    private final StatusService statusService;

    private final TaskService taskService;

    private final TaskRepository taskRepository;

    private final StatusRepository statusRepository;

    private UserService userService;


    public OrganizerController(
            StatusService statusService, TaskService taskService,
            StatusRepository statusRepository,
            TaskRepository taskRepository, UserService userService
    ) {
        this.statusService = statusService;
        this.taskService = taskService;
        this.statusRepository = statusRepository;
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    // Получение всех задач
    @GetMapping()
    public String listTask(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "list";
    }

    // Просмотр задачи
    @GetMapping("task/{id}")
    public String task(@PathVariable("id") int id, Model model) {
        Task task = taskService.findByUserId(id);
        model.addAttribute("task", task);
        return "view-task";
    }

    // Страница создания новой задачи
    @GetMapping("new-task")
    public String storeTemplateTask(Model model) {
        model.addAttribute("statuses", statusRepository.findAll());
        return "edit";
    }

    // Сохранение новой задачи
    @PostMapping("new-task")
    public String storeTask(Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }


    @GetMapping("/new-status")
    public String storeTemplateStatus() {
        return "status-edit";
    }

    @PostMapping("/new-status")
    public String storeStatus(Status status) {
        statusService.newCreate(status);
        return "redirect:/";
    }

}
