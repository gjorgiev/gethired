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
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "country", nullable = false)
    private String country;
    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<User> users;
    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<Job> jobs;
}
