package com.example.Cricbuzz.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="name", nullable = false)
    String name;


    @Column(name="coach", nullable = false)
    String coach;


    @Column(name="matchesPlayed", nullable = false)
    int matchesPlayed;


    @Column(name="ranking", nullable = false)
    int ranking;


    @Column(name="iccPoints", nullable = false)
    int iccPoints;

    @JsonManagedReference
    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
    List<Player> player;


    @JsonManagedReference
    @ManyToMany(mappedBy = "teams",cascade = CascadeType.ALL)
    List<CricketMatch> matches;
}


