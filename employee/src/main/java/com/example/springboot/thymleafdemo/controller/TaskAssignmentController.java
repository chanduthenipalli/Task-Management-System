package com.example.springboot.thymleafdemo.controller;

import com.example.springboot.thymleafdemo.Service.TaskAssignmentService;
import com.example.springboot.thymleafdemo.entity.LogsStatus;
import com.example.springboot.thymleafdemo.Service.LogsStatusService;
import com.example.springboot.thymleafdemo.entity.TaskAssignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/taskassignments")
public class TaskAssignmentController
{

    @Autowired
    private TaskAssignmentService taskAssignmentService;

    @Autowired
    private LogsStatusService logs;

    /**
     * Get a list of all task assignments.
     *
     * @return List of TaskAssignment objects.
     * This method retrieves a list of all task assignments. Details about tasks and team members
     * are included based on the foreign key relationships defined in the TaskAssignment entity.
     */
    @GetMapping("/getallassignments")
    public List<TaskAssignment> getAllTaskAssignments()
    {
        return taskAssignmentService.getAllTaskAssignments();
    }

    /**
     * Get a specific task assignment by its ID.
     *
     * @param assignmentId The ID of the task assignment to retrieve.
     * @return The TaskAssignment object corresponding to the provided ID.
     * This method retrieves a specific task assignment by its ID. Details about the associated task
     * and team member are included based on the foreign key relationships.
     */
    @GetMapping("/getassignment/{assignmentId}")
    public TaskAssignment getTaskAssignmentById(@PathVariable Long assignmentId)
    {
        return taskAssignmentService.getTaskAssignmentById(assignmentId);
    }

    /**
     * Create a new task assignment.
     *
     * This method expects a JSON body with 'task_id' and 'emp_id' fields. It parses these values,
     * uses the TaskAssignmentService to create a new TaskAssignment, and returns the created TaskAssignment.
     *
     * @param requestBody A Map containing 'task_id' and 'emp_id' keys.
     *                    task_id values will get from task api,emp_id values will get from
     *                    teammembers api beacuase of foreign key,
     *                    The values are used to create a new TaskAssignment.
     * @return The created TaskAssignment object.
     *
     * The @RequestBody Map<String, Object> approach is useful for scenarios where flexibility
     * with input data is needed, especially during rapid development or when dealing with
     * dynamic or complex JSON structures. However, for better readability and maintainability,
     * especially in production applications, defining explicit DTOs might be preferred.
     */

    @PostMapping("/assigntask")
    public TaskAssignment createTaskAssignment(@RequestBody Map<String, Object> requestBody)
    {
        // Extract task_id and emp_id from the request body
        Long taskId = Long.parseLong(requestBody.get("task_id").toString());
        Long empId = Long.parseLong(requestBody.get("emp_id").toString());

        // Use the service to create the task assignment
        TaskAssignment taskAssignment = taskAssignmentService.createTaskAssignment(taskId, empId);

        // Create a new LogsStatus entry
        LogsStatus logsStatus = new LogsStatus();

        // Set the Task and TeamMember in LogsStatus using the TaskAssignment just created
        logsStatus.setTask(taskAssignment.getTask());
        logsStatus.setTeamMember(taskAssignment.getTeamMember());

        // Set the status of the log entry to "Assigned"
        logsStatus.setStatus("Assigned");

        // Set the current timestamp for the log entry
        logsStatus.setTimestamp(LocalDateTime.now());

        // Save the LogsStatus entry using the service method
        logs.createLogsStatus(logsStatus);

        // Return the created task assignment
        return taskAssignment;
    }


    /**
     * Update the status of an existing task assignment.
     *
     * This method expects a JSON body with a 'status' field to update the status of the task assignment.
     *
     * @param assignmentId The ID of the task assignment to update.
     * @param requestBody A Map containing a 'status' field with the new status value.
     * @return The updated TaskAssignment object.
     */
    @PutMapping("/updatetask/{assignmentId}")
    public TaskAssignment updateTaskAssignment(@PathVariable Long assignmentId, @RequestBody Map<String, Object> requestBody)
    {
        // Extract the status from the request body
        String status = requestBody.get("status").toString();

        // Call the service method to update the TaskAssignment status
        TaskAssignment t = taskAssignmentService.updateTaskAssignmentStatus(assignmentId, status);

        // Create a new LogsStatus entry
        LogsStatus logsStatus = new LogsStatus();

        // Set the Task and TeamMember in LogsStatus using the Task and TeamMember from the updated TaskAssignment
        // The TaskAssignment entity already has relationships with Task and TeamMember.
        // Thus, we use taskAssignment.getTask() and taskAssignment.getTeamMember() to get the related entities.
        // This ensures that LogsStatus maintains accurate references to the Task and TeamMember involved.
        logsStatus.setTask(t.getTask());
        logsStatus.setTeamMember(t.getTeamMember());

        // Set the status of the log entry
        logsStatus.setStatus(status);

        // Set the current timestamp for the log entry
        logsStatus.setTimestamp(LocalDateTime.now());

        // Save the LogsStatus entry using the service method
        logs.createLogsStatus(logsStatus);

        // Return the updated TaskAssignment
        return t;
    }
    /**
     * Delete a specific task assignment by its ID.
     *
     * @param assignmentId The ID of the task assignment to delete.
     * @return A message indicating the result of the deletion.
     */
    @DeleteMapping("/deletetask/{assignmentId}")
    public String deleteTaskAssignment(@PathVariable Long assignmentId)
    {
        taskAssignmentService.deleteTaskAssignment(assignmentId);
        return "Task Assignment with ID " + assignmentId + " has been deleted.";
    }

/*
    // API
    1. API to get list of logs based on task_id
            //task_id
            // task_id, emp_name , status, time (sorted based on time)
    2. UpdateStatus
    On-going, Done, Blocked
    POST
    {
   "task_id"
           "emp_id"
                   "status"
    }
    }
    task_assignment_table
    log_Status
            3. REST API Reccomendataions (url & Request formats)
            4. Design patterns
            5. MVC (filters)
            6.Custom Queries
            */


}
