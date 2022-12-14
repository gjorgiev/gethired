package com.gjorgiev.gethired.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @Column(name = "remote")
    private boolean remote;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @ManyToMany
    @JoinTable(
            name = "jobs_skills",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;
    @ManyToMany(mappedBy = "results")
    @JsonIgnore
    private List<RecentSearch> appearedIn;

    public Job(String title, String description, Company company, boolean remote, Location location) {
        this.title = title;
        this.description = description;
        this.company = company;
        this.remote = remote;
        this.location = location;
        this.skills = new ArrayList<>();
    }

    public Job(){
        this.skills = new ArrayList<>();
    }

}
