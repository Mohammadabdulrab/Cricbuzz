package com.example.Cricbuzz.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int runs;

    int wickets;

    double battingAvg;


    double bowlingAvg;


    @OneToOne
    @JoinColumn
    Player player;
}
