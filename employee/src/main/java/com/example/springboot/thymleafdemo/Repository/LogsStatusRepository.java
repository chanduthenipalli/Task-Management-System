package com.example.springboot.thymleafdemo.Repository;

import com.example.springboot.thymleafdemo.entity.LogsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogsStatusRepository extends JpaRepository<LogsStatus, Long>
{
    // Custom query methods (if needed) can be defined here

    List<LogsStatus> findByTaskId(Long taskId);
}
