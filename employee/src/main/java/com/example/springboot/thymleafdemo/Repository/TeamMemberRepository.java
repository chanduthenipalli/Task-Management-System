package com.example.springboot.thymleafdemo.Repository;

import com.example.springboot.thymleafdemo.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    Optional<TeamMember> findByEmpName(String empName);
}
