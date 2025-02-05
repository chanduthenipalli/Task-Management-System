package com.example.springboot.thymleafdemo.controller;

import com.example.springboot.thymleafdemo.Service.TeamMemberService;
import com.example.springboot.thymleafdemo.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teammembers")
public class TeamMemberController {

    @Autowired
    private TeamMemberService teamMemberService;

    /**
     * Fetches all team members.
     *
     * @return a list of all TeamMember entities
     */
    @GetMapping("/getallmembers")
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberService.getAllTeamMembers();
    }

    /**
     * Fetches a team member by its ID.
     *
     * @param empId the ID of the team member to be retrieved
     * @return the TeamMember entity if found
     * @throws RuntimeException if the team member is not found
     */
    @GetMapping("/getmember/{empId}")
    public TeamMember getTeamMemberById(@PathVariable Long empId) {
        return teamMemberService.getTeamMemberById(empId);
    }

    /**
     * Creates a new team member.
     *
     * @param teamMember the TeamMember entity to be created
     * @return the created TeamMember entity
     */
    @PostMapping("/createmember")
    public TeamMember createTeamMember(@RequestBody TeamMember teamMember) {
        return teamMemberService.createTeamMember(teamMember);
    }

    /**
     * Updates an existing team member.
     *
     * @param empId the ID of the team member to be updated
     * @param teamMember the TeamMember entity with updated information
     * @return the updated TeamMember entity
     * @throws RuntimeException if the team member is not found
     */
    @PutMapping("/updatemember/{empId}")
    public TeamMember updateTeamMember(@PathVariable Long empId, @RequestBody TeamMember teamMember) {
        return teamMemberService.updateTeamMember(empId, teamMember);
    }

}
