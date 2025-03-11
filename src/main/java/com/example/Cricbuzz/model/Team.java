package com.example.Cricbuzz.model;


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
    int id;

    String name;


    String coach;

    int matchesPlayed;


    int ranking;


    int iccPoints;

    @OneToMany(mappedBy = "team")
    List<Player> player;


    @ManyToMany(mappedBy = "teams")
    List<CricketMatch> matches;
}


