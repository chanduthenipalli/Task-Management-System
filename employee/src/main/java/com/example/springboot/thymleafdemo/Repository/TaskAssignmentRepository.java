package com.example.springboot.thymleafdemo.Repository;

import com.example.springboot.thymleafdemo.entity.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long>
{

}
