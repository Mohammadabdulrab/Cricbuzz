package com.example.Cricbuzz.model;

import com.example.Cricbuzz.model.enums.Gender;
import com.example.Cricbuzz.model.enums.Speciality;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="player")
@Entity
@Builder

public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="name", nullable = false)
    String name;

    @Column(name="age", nullable = false)
    int age;


    @Enumerated(EnumType.STRING)
    @Column(name="speciality", nullable = false)
    Speciality speciality;



    @Enumerated(EnumType.STRING)
    @Column(name="gender", nullable = false)
    Gender gender;

    @OneToOne(mappedBy = "player",cascade=CascadeType.ALL)
    @JsonManagedReference
    PlayerProfile playerProfile;


    @ManyToOne
    @JoinColumn
    @JsonBackReference
    Team team;



}
