package com.example.Cricbuzz.service;

import com.example.Cricbuzz.convertor.PlayerProfileConvertor;
import com.example.Cricbuzz.dto.request.PlayerProfileRequest;
import com.example.Cricbuzz.dto.response.PlayerProfileResponse;
import com.example.Cricbuzz.exception.PlayerNotFoundException;
import com.example.Cricbuzz.model.Player;
import com.example.Cricbuzz.model.PlayerProfile;
import com.example.Cricbuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerProfileService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerProfileResponse addPlayerProfile(PlayerProfileRequest playerProfileRequest, int playerId) {
      Optional<Player> optionalPlayer=    playerRepository.findById(playerId);

      if(optionalPlayer.isEmpty()){
          throw new PlayerNotFoundException("Invalid player id:");
      }

      Player player=optionalPlayer.get();

        PlayerProfile playerProfile= PlayerProfileConvertor.playerProfileRequestToPlayerProfile(playerProfileRequest);

        player.setPlayerProfile(playerProfile);
        playerProfile.setPlayer(player);

        Player savedPlayer = playerRepository.save(player); // saves both player and playerProfile
        return PlayerProfileConvertor.playerProfileToPlayerProfileResponse(savedPlayer.getPlayerProfile());
    }
}
