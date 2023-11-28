package com.example.umc.dto;

import com.example.umc.domain.Member;
import com.example.umc.domain.MemberMission;
import com.example.umc.domain.Mission;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;

@Builder
public record CreateMemberMissionRequest(
        String status,
        Long memberId,
        Long missionId
) {

}
