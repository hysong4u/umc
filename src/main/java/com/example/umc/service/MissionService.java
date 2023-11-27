package com.example.umc.service;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Store;
import com.example.umc.dto.CreateMissionRequest;
import com.example.umc.repository.MissionRepository;
import com.example.umc.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MissionService {

    private final StoreRepository StoreRepository;
    private final MissionRepository missionRepository;
    @Transactional
    public Mission createMission(CreateMissionRequest request) {
        Store store = StoreRepository.findById(request.storeId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Mission mission = Mission.builder()
                .reward(request.reward())
                .deadline(request.deadline())
                .missionSpec(request.missionSpec())
                .store(store)
                .build();

        return missionRepository.save(mission);
    }

}
