package com.example.springboot.thymleafdemo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// Entity representing the LogsStatus table in the database
@Entity
@Table(name = "logs_status")
public class LogsStatus {

    // Primary key for the LogsStatus entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with Task entity
    @ManyToOne
    @JoinColumn(name = "task_id") // Foreign key column in the logs_status table
    private Task task;

    // Many-to-One relationship with TeamMember entity
    @ManyToOne
    @JoinColumn(name = "emp_id") // Foreign key column in the logs_status table
    private TeamMember teamMember;

    // Status of the log entry
    private String status;

    // Timestamp for the log entry
    private LocalDateTime timestamp;

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the task
    public Task getTask() {
        return task;
    }

    // Setter for the task
    public void setTask(Task task) {
        this.task = task;
    }

    // Getter for the team member
    public TeamMember getTeamMember() {
        return teamMember;
    }

    // Setter for the team member
    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    // Getter for the status
    public String getStatus() {
        return status;
    }

    // Setter for the status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for the timestamp
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setter for the timestamp
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
