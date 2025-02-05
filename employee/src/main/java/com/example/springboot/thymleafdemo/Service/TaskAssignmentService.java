package com.example.springboot.thymleafdemo.Service;

import com.example.springboot.thymleafdemo.Repository.TaskAssignmentRepository;
import com.example.springboot.thymleafdemo.Repository.TaskRepository;
import com.example.springboot.thymleafdemo.Repository.TeamMemberRepository;
import com.example.springboot.thymleafdemo.entity.Task;
import com.example.springboot.thymleafdemo.entity.TaskAssignment;
import com.example.springboot.thymleafdemo.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskAssignmentService {

    @Autowired
    private TaskAssignmentRepository taskAssignmentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    public List<TaskAssignment> getAllTaskAssignments() {
        return taskAssignmentRepository.findAll();
    }

    public TaskAssignment getTaskAssignmentById(Long assignmentId) {
        return taskAssignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Task Assignment not found"));
    }

    public TaskAssignment createTaskAssignment(Long taskId, Long empId)
    {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        TeamMember teamMember = teamMemberRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Team Member not found"));

        TaskAssignment taskAssignment = new TaskAssignment();
        //here we are retriving the data of task and teammember data with their id's and setting
        //that data to task_id and teammember_id  and saving data in
        taskAssignment.setTask(task);
        taskAssignment.setTeamMember(teamMember);
        taskAssignment.setStatus("Assigned"); // Automatically set the status
        return taskAssignmentRepository.save(taskAssignment);//creating entity in table but in
        // table it will store only id but in postman it will show us deatils also of task,teammember
    }

    public TaskAssignment updateTaskAssignmentStatus(Long assignmentId, String status)
    {
        TaskAssignment taskAssignment = taskAssignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Task Assignment not found"));
        taskAssignment.setStatus(status);
        return taskAssignmentRepository.save(taskAssignment);
    }

    public void deleteTaskAssignment(Long assignmentId) {
        TaskAssignment taskAssignment = taskAssignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Task Assignment not found"));
        taskAssignmentRepository.delete(taskAssignment);
    }
}
