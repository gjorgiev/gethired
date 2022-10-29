package com.gjorgiev.gethired.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "searches")
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "keywords", nullable = false)
    private String keywords;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @Column(name = "remote")
    private boolean remote;
    @ManyToMany
    @JoinTable(
            name = "searches_jobs",
            joinColumns = @JoinColumn(name = "search_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id"))
    private List<Job> results;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
