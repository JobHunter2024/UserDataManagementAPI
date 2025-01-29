package com.jobhunter24.UserDataManagementAPI.api.service;

import com.jobhunter24.UserDataManagementAPI.api.entity.Technology;

import java.util.List;

public interface ITechnologyService {
    Technology getTechnologyById(Long id);

    List<Technology> getAllTechnologies();

    List<Technology> getTechnologiesByUser(Long userId);

    Technology addTechnology(Technology technology);

    void removeTechnology(Long technologyId);
}
