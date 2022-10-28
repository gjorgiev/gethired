package com.gjorgiev.gethired.services;

import com.gjorgiev.gethired.models.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {
    Page<Job> getJobs(Pageable pageable);
    Job getJobById(Long jobId);
}
