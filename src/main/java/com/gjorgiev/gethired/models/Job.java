package com.gjorgiev.gethired.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
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
            name = "job_skills",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills = new ArrayList<>();
    @ManyToMany(mappedBy = "results")
    private List<Search> appearedIn;

    public Job(String title, String description, Company company, boolean remote, Location location) {
        this.title = title;
        this.description = description;
        this.company = company;
        this.remote = remote;
        this.location = location;
    }

}
