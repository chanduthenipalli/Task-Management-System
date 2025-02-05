package com.example.springboot.thymleafdemo.Service;

import com.example.springboot.thymleafdemo.Repository.TeamMemberRepository;
import com.example.springboot.thymleafdemo.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    /**
     * Fetches all team members.
     *
     * @return a list of all TeamMember entities
     */
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }
    public Optional<TeamMember> findByEmpName(String empName) {
        return teamMemberRepository.findByEmpName(empName);
    }

    /**
     * Fetches a team member by its ID.
     *
     * @param id the ID of the team member to be retrieved
     * @return the TeamMember entity if found
     * @throws RuntimeException if the team member is not found
     */
    public TeamMember getTeamMemberById(Long id) {
        return teamMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team Member not found with ID: " + id));
    }


    /**
     * Creates a new team member.
     *
     * @param teamMember the TeamMember entity to be created
     * @return the created TeamMember entity
     */
    public TeamMember createTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    /**
     * Updates an existing team member.
     *
     * @param empId the ID of the team member to be updated
     * @param teamMember the TeamMember entity with updated information
     * @return the updated TeamMember entity
     * @throws RuntimeException if the team member is not found
     */
    public TeamMember updateTeamMember(Long empId, TeamMember teamMember)
    {
        TeamMember existingTeamMember = teamMemberRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Team Member not found"));
        existingTeamMember.setEmpName(teamMember.getEmpName());
        existingTeamMember.setDepartment(teamMember.getDepartment());
        return teamMemberRepository.save(existingTeamMember);
    }
}
