package com.example.umc.controller;

import com.example.umc.dto.CreateMissionRequest;
import com.example.umc.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/mission")
@RestController
public class MissionController {
    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<Void> createMission(@RequestBody final CreateMissionRequest request) {
        missionService.createMission(request);
        return ResponseEntity.noContent().build();
    }

}
