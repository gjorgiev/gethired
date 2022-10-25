package com.gjorgiev.gethired.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<Job> openPositions;

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Job> getOpenPositions() {
        return openPositions;
    }

    public void setOpenPositions(List<Job> openPositions) {
        this.openPositions = openPositions;
    }
}
