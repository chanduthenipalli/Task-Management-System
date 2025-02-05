package com.example.springboot.thymleafdemo.Security;

import com.example.springboot.thymleafdemo.Service.TeamMemberService;
import com.example.springboot.thymleafdemo.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig
{

    @Autowired
    private TeamMemberService teamMemberService;

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        // Create users based on static data
        UserDetails chandu = User.builder()
                .username("chandu")
                .password("{noop}Chandu@7079")
                .roles("USER")
                .build();

        UserDetails kiran = User.builder()
                .username("kiran")
                .password("{noop}Chandu@7079")
                .roles("USER", "EMPLOYEE")
                .build();

        UserDetails rajesh = User.builder()
                .username("rajesh")
                .password("{noop}Chandu@7079")
                .roles("USER", "EMPLOYEE", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(chandu, kiran, rajesh);
    }*/
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        // Create users based on static data
        UserDetails chandu = User.builder()
                .username("chandu")
                .password("{noop}Chandu@7079")
                .roles("USER")
                .build();

        UserDetails kiran = User.builder()
                .username("kiran")
                .password("{noop}Chandu@7079")
                .roles("USER", "EMPLOYEE")
                .build();

        // Fetch team member details dynamically
        TeamMember rajeshTeamMember = teamMemberService.getTeamMemberById(1L); // Assuming this returns a TeamMember object
        UserDetails rajesh = User.builder()
                .username(rajeshTeamMember.getEmpName()) // Adjust method based on your TeamMember model
                .password("{noop}Chandu@7079") // Should be dynamically fetched or hashed properly
                .roles("USER", "EMPLOYEE", "ADMIN") // Adjust roles based on your logic
                .build();

        return new InMemoryUserDetailsManager(chandu, kiran, rajesh);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.PUT, "/api/tasks/**").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/tasks/**").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/tasks/getstatus/**").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/api/tasks/**").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/logstatus/**").hasAnyRole("USER", "EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/logstatus/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/teammembers/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/taskassignments/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.PUT, "/api/taskassignments/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.DELETE, "/api/taskassignments/**").hasRole("EMPLOYEE")
                .requestMatchers("/**").hasRole("ADMIN") // All access for MANAGER
                .anyRequest().authenticated());

        // Use HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults());

        // Disable Cross-Site Request Forgery (CSRF)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
