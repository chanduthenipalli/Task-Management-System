package com.example.springboot.thymleafdemo.Service;


import com.example.springboot.thymleafdemo.Repository.TeamMemberRepository;
import com.example.springboot.thymleafdemo.entity.LogsStatus;
import com.example.springboot.thymleafdemo.Repository.LogsStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogsStatusService {

    private final LogsStatusRepository logsStatusRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    public LogsStatusService(LogsStatusRepository logsStatusRepository) {
        this.logsStatusRepository = logsStatusRepository;
    }

    // Create a new LogsStatus entry
    public  LogsStatus createLogsStatus(LogsStatus logsStatus) {
        return logsStatusRepository.save(logsStatus);
    }

    // Find LogsStatus entries by task_id
    public List<LogsStatus> findLogsStatusByTaskId(Long taskId)
    {
        return logsStatusRepository.findByTaskId(taskId);
    }

}
