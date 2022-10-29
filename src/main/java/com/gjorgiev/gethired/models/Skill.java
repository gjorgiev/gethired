package com.gjorgiev.gethired.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    private String description;
    @ManyToMany(mappedBy = "skills")
    @JsonIgnore
    private List<User> users;
    @ManyToMany(mappedBy = "skills")
    @JsonIgnore
    private List<Job> jobs;
}
