package com.gjorgiev.gethired.controllers;

import com.gjorgiev.gethired.models.Job;
import com.gjorgiev.gethired.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
