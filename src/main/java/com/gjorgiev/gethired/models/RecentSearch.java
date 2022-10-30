package com.gjorgiev.gethired.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "recent_searches")
public class RecentSearch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> keywords;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @Column(name = "remote")
    private boolean remote;
    @ManyToMany
    @JoinTable(
            name = "recent_searches_jobs",
            joinColumns = @JoinColumn(name = "recent_search_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id"))
    private List<Job> results;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    public RecentSearch(){
        this.keywords = new ArrayList<>();
    }
}
