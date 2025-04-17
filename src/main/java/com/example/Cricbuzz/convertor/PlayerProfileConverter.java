package com.example.Cricbuzz.convertor;

import com.example.Cricbuzz.dto.request.PlayerProfileRequest;
import com.example.Cricbuzz.dto.response.PlayerProfileResponse;
import com.example.Cricbuzz.dto.response.PlayerResponse;
import com.example.Cricbuzz.model.PlayerProfile;

public class PlayerProfileConverter {
    public static PlayerProfile playerProfileRequestToPlayerProfile(PlayerProfileRequest playerProfileRequest){
        return PlayerProfile.builder()
                .runs(playerProfileRequest.getRuns())
                .wickets(playerProfileRequest.getWickets())
                .battingAvg(playerProfileRequest.getBattingAvg())
                .bowlingAvg(playerProfileRequest.getBowlingAvg())
                .build();
    }

    public static PlayerProfileResponse playerProfileToPlayerProfileResponse(PlayerProfile playerProfile){
        return PlayerProfileResponse.builder()
                .runs(playerProfile.getRuns())
                .wickets(playerProfile.getWickets())
                .player(PlayerConvertor.playerToPlayerResponse(playerProfile.getPlayer()))
                .build();
    }
}
