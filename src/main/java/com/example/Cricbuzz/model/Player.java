package com.example.Cricbuzz.model;

import com.example.Cricbuzz.model.enums.Gender;
import com.example.Cricbuzz.model.enums.Speciality;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;


    @Enumerated(EnumType.STRING)
    Speciality speciality;



    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "player")
    PlayerProfile playerProfile;


    @ManyToOne
    @JoinColumn
    Team team;



}
