package com.example.umc.dto;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Store;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateMissionRequest(
        Integer reward,
        LocalDate deadline,
        String missionSpec,
        Long storeId
) {

}
