package com.example.Cricbuzz.dto.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerProfileResponse {
    int runs;

    int wickets;

    PlayerResponse player;

}
