package com.example.umc.service;

import com.example.umc.domain.Member;
import com.example.umc.domain.MemberMission;
import com.example.umc.domain.Mission;
import com.example.umc.domain.MissionStatus;
import com.example.umc.dto.CreateMemberMissionRequest;
import com.example.umc.repository.MemberMissionRepository;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {

    @Autowired
    public MemberRepository memberRepository;
    @Autowired
    public MissionRepository missionRepository;
    @Autowired
    public MemberMissionRepository MemberMissionRepository;

    @Transactional
    public MemberMission createMemberMission(CreateMemberMissionRequest request) {
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Mission mission = missionRepository.findById(request.missionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));

        MemberMission membermission = MemberMission.builder()
                .status(MissionStatus.valueOf(request.status()))
                .member(member)
                .mission(mission)
                .build();
        return MemberMissionRepository.save(membermission);
    }
}
