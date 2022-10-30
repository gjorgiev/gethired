package com.gjorgiev.gethired.services;

import com.gjorgiev.gethired.dto.request.JobRequest;
import com.gjorgiev.gethired.dto.request.SearchRequest;
import com.gjorgiev.gethired.dto.response.JobResponse;
import com.gjorgiev.gethired.models.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobService {
    Page<Job> getJobs(Pageable pageable);
    Job getJobById(Long jobId);
    Job createNewJob(JobRequest jobRequest);
    JobResponse updateJob(Long jobId, JobRequest jobRequest);
    void deleteJob(Long jobId);
    List<JobResponse> searchJobs(SearchRequest searchRequest);
}
