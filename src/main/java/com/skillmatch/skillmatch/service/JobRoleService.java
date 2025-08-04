package com.skillmatch.skillmatch.service;

import com.skillmatch.skillmatch.model.JobRole;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class JobRoleService {
    private final List<JobRole> jobRoles = List.of(
            new JobRole("1", "Java Developer", "Java dev role", List.of("Java", "Spring Boot", "SQL")),
            new JobRole("2", "DevOps Engineer", "DevOps role", List.of("Docker", "Kubernetes", "AWS")),
            new JobRole("3", "Data Engineer", "Data engineering role", List.of("Python", "Kafka", "SQL"))
    );

    public List<JobRole> getAllRoles() {
        return jobRoles;
    }

    public Map<String, Double> matchSkillsToRoles(Set<String> candidateSkills) {
        Map<String, Double> roleScores = new HashMap<>();

        for (JobRole role : jobRoles) {
            List<String> requiredSkills = role.getRequiredSkills();
            if (requiredSkills == null || requiredSkills.isEmpty()) {
                roleScores.put(role.getTitle(), 0.0);
                continue;
            }

            long matchedCount = candidateSkills.stream()
                    .filter(skill -> requiredSkills.contains(skill))
                    .count();

            double score = (matchedCount * 100.0) / requiredSkills.size();
            roleScores.put(role.getTitle(), score);
        }
        return roleScores;
    }
}
