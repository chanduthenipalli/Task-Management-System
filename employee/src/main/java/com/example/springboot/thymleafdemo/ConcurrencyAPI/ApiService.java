package com.example.springboot.thymleafdemo.ConcurrencyAPI;

import com.example.springboot.thymleafdemo.entity.Task;
import com.example.springboot.thymleafdemo.entity.TaskAssignment;
import com.example.springboot.thymleafdemo.entity.TeamMember;
import com.example.springboot.thymleafdemo.entity.LogsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * ApiService: A service that uses RestTemplate to fetch data from the Task,
 * TeamMember, TaskAssignment, and LogsStatus APIs asynchronously. The service methods are annotated
 * with @Async to enable asynchronous execution and return results as CompletableFuture objects.
 */
@Service
public class ApiService {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetches the list of tasks asynchronously.
     * @return A CompletableFuture containing the list of tasks.
     */
    @Async
    public CompletableFuture<List<Task>> getTasks() {
        // Define the URL for the tasks API
        String url = "http://localhost:8080/api/tasks";

        // Perform a GET request to the tasks API and retrieve the response
        ResponseEntity<List<Task>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Task>>() {}
        );

        // Return the response body wrapped in a CompletableFuture
        return CompletableFuture.completedFuture(response.getBody());
    }

    /**
     * Fetches the list of team members asynchronously.
     * @return A CompletableFuture containing the list of team members.
     */
    @Async
    public CompletableFuture<List<TeamMember>> getTeamMembers() {
        // Define the URL for the team members API
        String url = "http://localhost:8080/api/teammembers";

        // Perform a GET request to the team members API and retrieve the response
        ResponseEntity<List<TeamMember>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TeamMember>>() {}
        );

        // Return the response body wrapped in a CompletableFuture
        return CompletableFuture.completedFuture(response.getBody());
    }

    /**
     * Fetches the list of task assignments asynchronously.
     * @return A CompletableFuture containing the list of task assignments.
     */
    @Async
    public CompletableFuture<List<TaskAssignment>> getTaskAssignments() {
        // Define the URL for the task assignments API
        String url = "http://localhost:8080/api/taskassignments";

        // Perform a GET request to the task assignments API and retrieve the response
        ResponseEntity<List<TaskAssignment>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TaskAssignment>>() {}
        );

        // Return the response body wrapped in a CompletableFuture
        return CompletableFuture.completedFuture(response.getBody());
    }

    /**
     * Fetches the list of logs status asynchronously.
     * @return A CompletableFuture containing the list of logs status.
     */
    @Async
    public CompletableFuture<List<LogsStatus>> getLogsStatus() {
        // Define the URL for the logs status API
        String url = "http://localhost:8080/api/logstatus";

        // Perform a GET request to the logs status API and retrieve the response
        ResponseEntity<List<LogsStatus>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LogsStatus>>() {}
        );

        // Return the response body wrapped in a CompletableFuture
        return CompletableFuture.completedFuture(response.getBody());
    }
}
