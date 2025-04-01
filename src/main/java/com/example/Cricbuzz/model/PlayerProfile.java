package com.example.Cricbuzz.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="playerProfile")
@Builder

public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="runs",nullable = false)
    int runs;

    @Column(name="wickets",nullable = false)
    int wickets;


    @Column(name="battingAvg",nullable = false)
    double battingAvg;



    @Column(name="bowlingAvg", nullable = false)
    double bowlingAvg;


    @OneToOne
    @JoinColumn
    @JsonBackReference
    Player player;
}
