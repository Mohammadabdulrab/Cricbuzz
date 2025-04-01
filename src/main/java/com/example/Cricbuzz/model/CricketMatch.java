package com.example.Cricbuzz.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="cricketMatch")
@Builder

public class CricketMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="tutle", nullable = false)
    String tutle;

    @Column(name="venue" , nullable = false)
    String venue;


    @CreationTimestamp
    @Column(name="created",nullable = false)
    Date created;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name="match_team", joinColumns=@JoinColumn(name="match_id"),
    inverseJoinColumns = @JoinColumn(name="team_id"))
    List<Team> teams;
}
