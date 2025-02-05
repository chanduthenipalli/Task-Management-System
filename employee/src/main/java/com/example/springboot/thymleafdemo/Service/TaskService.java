package com.example.springboot.thymleafdemo.Service;

import com.example.springboot.thymleafdemo.Repository.TaskRepository;
import com.example.springboot.thymleafdemo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * Fetches all tasks.
     *
     * @return a list of all Task entities
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Fetches a task by its ID.
     *
     * @param taskId the ID of the task to be retrieved
     * @return the Task entity if found
     * @throws RuntimeException if the task is not found
     */
    public Task getTaskById(Long taskId)
    {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    /**
     * Creates a new task.
     *
     * @param task the Task entity to be created
     * @return the created Task entity
     */
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Updates an existing task.
     *
     * @param taskId the ID of the task to be updated
     * @param task the Task entity with updated information
     * @return the updated Task entity
     * @throws RuntimeException if the task is not found
     */
    public Task updateTask(Long taskId, Task task)
    {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        existingTask.setTaskName(task.getTaskName());
        existingTask.setTaskDescription(task.getTaskDescription());
        return taskRepository.save(existingTask);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param taskId the ID of the task to be deleted
     * @throws RuntimeException if the task is not found
     */
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }
}
