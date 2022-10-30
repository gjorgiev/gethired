package com.gjorgiev.gethired.controllers;

import com.gjorgiev.gethired.dto.request.JobRequest;
import com.gjorgiev.gethired.dto.request.SearchRequest;
import com.gjorgiev.gethired.dto.response.JobResponse;
import com.gjorgiev.gethired.models.Job;
import com.gjorgiev.gethired.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobs")
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity<Page<Job>> getJobs(@PageableDefault(size = 10) Pageable pageable){
        return ResponseEntity.ok(jobService.getJobs(pageable));
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId){
        return ResponseEntity.ok(jobService.getJobById(jobId));
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@Valid @RequestBody JobRequest jobRequest){
        return ResponseEntity.ok(jobService.createNewJob(jobRequest));
    }

    @PostMapping("/search")
    public ResponseEntity<List<JobResponse>> searchJobs(@Valid @RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(jobService.searchJobs(searchRequest));
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<JobResponse> updateJob(@PathVariable Long jobId, JobRequest jobRequest){
        return ResponseEntity.ok(jobService.updateJob(jobId, jobRequest));
    }

    @DeleteMapping("/{jobId}")
    public void deleteJob(@PathVariable Long jobId){
        jobService.deleteJob(jobId);
    }
}
