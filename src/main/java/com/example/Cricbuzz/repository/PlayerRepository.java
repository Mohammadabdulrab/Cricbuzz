package com.example.Cricbuzz.repository;

import com.example.Cricbuzz.model.Player;
import com.example.Cricbuzz.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    //By using Custom method
    List<Player> findByGenderAndAgeGreaterThan(Gender gender, int age);

    //NON - NATIVE  QUERY
    // By default native query is false it is call JPQL (java persistence Query language)
    //@Query(value = "SELECT p FROM Player p WHERE p.gender=:gender AND p.speciality=:speciality",nativeQuery = false)

    @Query(value = "SELECT * FROM player WHERE gender=:gender AND speciality=:speciality",nativeQuery = true)
    List<Player> getByGenderAndSpeciality(String gender, String speciality);
}
