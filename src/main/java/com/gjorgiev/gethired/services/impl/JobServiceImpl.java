package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.exceptions.ApiRequestException;
import com.gjorgiev.gethired.models.Job;
import com.gjorgiev.gethired.repositories.JobRepository;
import com.gjorgiev.gethired.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    @Override
    public Page<Job> getJobs(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobRepository.findJobById(jobId)
                .orElseThrow(() -> new ApiRequestException("Job with id = " + jobId + " not found", HttpStatus.NOT_FOUND));
    }
}
