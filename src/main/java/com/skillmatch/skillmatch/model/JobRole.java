package com.skillmatch.skillmatch.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "job_roles")

public class JobRole {
    @Id
    private String id;
    private String title;
    private String description;
    private List<String> requiredSkills;
}
