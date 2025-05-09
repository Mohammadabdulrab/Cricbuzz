package com.example.Cricbuzz.dto.response;

import com.example.Cricbuzz.model.enums.Speciality;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerResponse {


    String name;

    Speciality speciality;
}
