package com.skillmatch.skillmatch.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SkillExtractionService {
    private static final Set<String> predefinedSkills = new HashSet<>(Arrays.asList(
            "Java", "Spring Boot", "MongoDB", "SQL", "Docker", "Kubernetes",
            "AWS", "Python", "REST API", "Microservices", "Kafka"
    ));

    public Set<String> extractSkills(String resumeText) {
        Set<String> foundSkills = new HashSet<>();
        String textLower = resumeText.toLowerCase();

        for (String skill : predefinedSkills) {
            if (textLower.contains(skill.toLowerCase())) {
                foundSkills.add(skill);
            }
        }
        return foundSkills;
    }
}
