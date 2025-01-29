package com.jobhunter24.UserDataManagementAPI.api.repository;

import com.jobhunter24.UserDataManagementAPI.api.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    Optional<List<Technology>> findByUserId(Long userId);
}