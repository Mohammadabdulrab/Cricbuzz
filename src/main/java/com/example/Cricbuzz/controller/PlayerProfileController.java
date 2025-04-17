package com.example.Cricbuzz.controller;

import com.example.Cricbuzz.dto.request.PlayerProfileRequest;
import com.example.Cricbuzz.dto.response.PlayerProfileResponse;
import com.example.Cricbuzz.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/playerProfile")
public class PlayerProfileController {

    @Autowired
    PlayerProfileService playerProfileService;

    @PostMapping
    public PlayerProfileResponse addPlayerProfile(@RequestBody PlayerProfileRequest playerProfileRequest, @RequestParam("player-id") int playerId){
          return playerProfileService.addPlayerProfile(playerProfileRequest,playerId);
    }
}
