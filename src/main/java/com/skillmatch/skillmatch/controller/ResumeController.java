package com.skillmatch.skillmatch.controller;


import com.skillmatch.skillmatch.service.JobRoleService;
import com.skillmatch.skillmatch.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private JobRoleService jobRoleService;

    // Step 1: Upload resume and extract skills
    @PostMapping("/extract-skills")
    public ResponseEntity<Set<String>> extractSkills(@RequestParam("file") MultipartFile file) throws IOException {
        Set<String> skills = resumeService.extractSkillsFromResume(file);
        return ResponseEntity.ok(skills);
    }

    // Step 2: Upload resume, extract skills AND match them to roles in one go
    @PostMapping("/match-roles")
    public ResponseEntity<Map<String, Double>> extractSkillsAndMatchRoles(@RequestParam("file") MultipartFile file) throws IOException {
        // Extract skills
        Set<String> skills = resumeService.extractSkillsFromResume(file);

        // Match skills to job roles
        Map<String, Double> matches = jobRoleService.matchSkillsToRoles(skills);

        return ResponseEntity.ok(matches);
    }
}
