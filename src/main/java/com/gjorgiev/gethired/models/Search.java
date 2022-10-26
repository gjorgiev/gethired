package com.gjorgiev.gethired.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "searches")
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String keywords;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    private boolean remote;
    @OneToMany
    @JoinTable(
            name = "search_jobs",
            joinColumns = @JoinColumn(name = "search_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id"))
    private List<Job> results;

    public Search() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public List<Job> getResults() {
        return results;
    }

    public void setResults(List<Job> results) {
        this.results = results;
    }
}
