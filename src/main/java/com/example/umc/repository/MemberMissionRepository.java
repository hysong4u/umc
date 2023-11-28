package com.example.umc.repository;

import com.example.umc.domain.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMissionRepository  extends JpaRepository<MemberMission, Long> {
}
