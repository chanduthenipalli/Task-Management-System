# Task-Management-System
Task Management System:-

A simple and robust Task Management System built using Java (Spring Boot) and MySQL to manage tasks within an organization. The system allows users to create, update, delete, and track tasks with role-based access control and real-time notifications for task assignment.

Table of Contents
                 Features
                 Tech Stack
Features:-


Task Creation: Users can create tasks with titles, descriptions, due dates, and priority.
Task Updates: Users can update task details (status, assignee, due date, etc.).
Task Deletion: Users can delete tasks.
Task Tracking: Track the status of tasks (e.g., Pending, In Progress, Completed).
Assign Tasks to Users: Admins can assign tasks to users, with notifications.
Role-Based Access Control: Different user roles (Admin, Manager, Employee) to limit access to sensitive actions like task creation, deletion, and user management.
Notifications: Real-time email or in-app notifications when tasks are assigned or updated.


Tech Stack:-

Backend: Java with Spring Boot
Database: MySQL for storing tasks, users, and roles
RBAC: Implemented role management
Dependencies: Spring Boot Starter Web, Spring Boot Starter Security, Spring Boot Starter Data JPA, MySQL Driver
