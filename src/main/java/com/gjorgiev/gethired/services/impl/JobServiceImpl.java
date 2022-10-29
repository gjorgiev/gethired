package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.dto.request.JobRequest;
import com.gjorgiev.gethired.dto.response.JobResponse;
import com.gjorgiev.gethired.exceptions.ApiRequestException;
import com.gjorgiev.gethired.models.Job;
import com.gjorgiev.gethired.repositories.JobRepository;
import com.gjorgiev.gethired.services.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;
    @Override
    public Page<Job> getJobs(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobRepository.findJobById(jobId)
                .orElseThrow(() -> new ApiRequestException("Job with id = " + jobId + " not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Job createNewJob(JobRequest jobRequest) {
        Job job = modelMapper.map(jobRequest, Job.class);
        return jobRepository.save(job);
    }

    @Override
    public JobResponse updateJob(Long jobId, JobRequest jobRequest) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ApiRequestException("Job not found", HttpStatus.NOT_FOUND));
        job.setTitle(jobRequest.getTitle());
        job.setDescription(jobRequest.getDescription());
        job.setRemote(jobRequest.getRemote());
        return modelMapper.map(jobRepository.save(job), JobResponse.class);
    }

    @Override
    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }
}
