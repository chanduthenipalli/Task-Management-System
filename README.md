# Task-Management-System
Task Management System
A comprehensive Task Management System designed to help organizations effectively track and manage tasks, with role-based access control (RBAC) and integration of team member details (Masterdata). This system allows CRUD operations on tasks, assigning tasks to team members, updating task statuses, tracking progress, and maintaining logs for all actions.

Table of Contents:-
                    1. Description
                    2. Features
                    3. Tech Stack
                    
 1. Description:-
 
This Task Management System helps organizations manage their tasks in an efficient and structured way. The application stores team member details as masterdata, supports task creation, modification, deletion, and status updates. Tasks can be assigned to team members based on their roles, with proper access control ensuring only authorized users can perform specific actions.

2. Key Features:-

CRUD Operations on Tasks: Create, update, delete, and retrieve task details.
Assign Tasks to Team Members: Admins or managers can assign tasks to team members.
Change Status of Tasks: Tasks can have different statuses (e.g., "Pending", "In Progress", "Completed").
Track Progress: Track the progress of tasks using the status field and logs.
RBAC Implementation: Restrict task management actions based on roles (Admin, Manager, Employee).
Logging of Task Changes: Maintain a history of task actions and status updates for auditing purposes.
Features

CRUD Tasks:
Create: Users with appropriate roles can create tasks with relevant details like title, description, priority, due date, etc.
Read: Retrieve the task details.
Update: Change task details (e.g., due date, status, assignee).
Delete: Remove tasks (Admin role only).

Assign Tasks:
Tasks can be assigned to specific team members (employees) based on availability or skill set.
Admins or Managers can assign tasks via the API.

Task Status Updates:
Tasks can have various statuses (e.g., "Pending", "In Progress", "Completed").
Updates are logged to track the progression of tasks over time.

Track Progress and Logs:
Every action on a task is logged (e.g., task created, updated, deleted, assigned).
Task logs provide detailed history for auditing purposes.

RBAC (Role-Based Access Control):
Admin: Can create, update, delete tasks, assign tasks, and manage team members.
Manager: Can create and update tasks, assign tasks, and track task progress.
Employee: Can only view tasks assigned to them and update task status if allowed.



3. Tech Stack:-
Backend: Java (Spring Boot)
Database: MySQL (used for tasks, users, and logs)
ORM: Hibernate/JPA for database interaction
RBAC: Spring Security to implement role-based access control
Logging: Log4j or SLF4J for logging task changes

