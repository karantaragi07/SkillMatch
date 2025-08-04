package com.skillmatch.skillmatch.repository;

import com.skillmatch.skillmatch.model.JobRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRoleRepository extends MongoRepository<JobRole, String> {
}
