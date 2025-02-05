package com.example.springboot.thymleafdemo.entity;

import jakarta.persistence.*;

// Entity representing the TaskAssignment table in the database
@Entity
@Table(name = "task_assignments")
public class TaskAssignment {

    // Primary key for the TaskAssignment entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with Task entity
    @ManyToOne
    @JoinColumn(name = "task_id") // Foreign key column in the task_assignments table
    private Task task;

    // Many-to-One relationship with TeamMember entity
    @ManyToOne
    @JoinColumn(name = "emp_id") // Foreign key column in the task_assignments table
    private TeamMember teamMember;

    // Status of the task assignment
    private String status;

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the task
    public Task getTask()
    {
        return task;
    }

    // Setter for the task
    public void setTask(Task task)
    {
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
}
/*1.Many TaskAssignment entities can be associated with one Task (one task can have many assignments).
  2.Many TaskAssignment entities can be associated with one TeamMember
  (one team member can have many assignments).*/