package com.example.springboot.thymleafdemo.controller;

import com.example.springboot.thymleafdemo.Service.LogsStatusService;
import com.example.springboot.thymleafdemo.Service.TaskService;
import com.example.springboot.thymleafdemo.Service.TeamMemberService;
import com.example.springboot.thymleafdemo.entity.LogsStatus;
import com.example.springboot.thymleafdemo.entity.Task;
import com.example.springboot.thymleafdemo.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController
{

    @Autowired
    private TaskService taskService;
    @Autowired
    private LogsStatusService logs;
    @Autowired
    private TeamMemberService teamMemberService;

    /**
     * Fetches all tasks.
     *
     * @return a list of all Task entities
     */
    @GetMapping("/getalltasks")
    public List<Task> getAllTasks()
    {
        List<Task> list1  = taskService.getAllTasks();
        return list1;
    }

    /**
     * Fetches a task by its ID.
     *
     * @param taskId the ID of the task to be retrieved
     * @return the Task entity if found
     * @throws RuntimeException if the task is not found
     */
    @GetMapping("/gettask/{taskId}")
    public Task getTaskById(@PathVariable Long taskId)
    {
        Task t = taskService.getTaskById(taskId);//getting data and holding it
        return t;
    }
    @GetMapping("/getstatus/{taskId}")
    public List<LogsStatus> getTaskByTaskId(@PathVariable Long taskId) {
        // Use the LogsStatusService to retrieve all LogsStatus entries by taskId
        return logs.findLogsStatusByTaskId(taskId);
    }

    /**
     * Creates a new task.
     *
     * @param task the Task entity to be created
     * @return the created Task entity
     */
    /*
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        // Create the task using the service method
        Task t1 = taskService.createTask(task);
        // Return the created Task
        return t1;
    }*/
    @PostMapping("/createtask")
    public Task createTask(@RequestBody Task task) {
        // Create the task using the service method
        Task t1 = taskService.createTask(task);

        // Fetch the placeholder employee by empName
        TeamMember placeholderEmployee =
                teamMemberService.findByEmpName("Admin")
                .orElseThrow(() -> new RuntimeException("Placeholder employee not found"));

        // Create a log entry with the placeholder employee
        LogsStatus log = new LogsStatus();
        log.setTask(t1);//setting task
        log.setTeamMember(placeholderEmployee);//setting teammember
        log.setStatus("Created");//status
        log.setTimestamp(LocalDateTime.now());//timestamp

        logs.createLogsStatus(log);

        // Return the created Task
        return t1;
    }



    /**
     * Updates an existing task.
     *
     * @param taskId the ID of the task to be updated
     * @param task the Task entity with updated information
     * @return the updated Task entity
     * @throws RuntimeException if the task is not found
     */
    @PutMapping("/updatetask/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task)//request body is used to get the update details
    {
        return taskService.updateTask(taskId, task);
    }
}
