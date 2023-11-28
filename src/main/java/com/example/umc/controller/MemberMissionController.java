package com.example.umc.controller;

import com.example.umc.dto.CreateMemberMissionRequest;
import com.example.umc.service.MemberMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member-mission")
public class MemberMissionController {

    public final MemberMissionService memberMissionService;


    @PostMapping
    public ResponseEntity<Void> createMemberMission(@RequestBody final CreateMemberMissionRequest request) {
        memberMissionService.createMemberMission(request);
        return ResponseEntity.noContent().build();
    }
}
