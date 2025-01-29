package com.jobhunter24.UserDataManagementAPI.api.service;

import com.jobhunter24.UserDataManagementAPI.api.entity.Technology;
import com.jobhunter24.UserDataManagementAPI.api.exception.DuplicateTechnologyException;
import com.jobhunter24.UserDataManagementAPI.api.exception.TechnologyNotFoundException;
import com.jobhunter24.UserDataManagementAPI.api.repository.TechnologyRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements ITechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public Technology getTechnologyById(Long id) {
        return technologyRepository.findById(id)
                .orElseThrow(() -> new TechnologyNotFoundException("Technology not found with ID: " + id));
    }

    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll();
    }

    public List<Technology> getTechnologiesByUser(Long userId) {
        return technologyRepository.findByUserId(userId)
                .orElseThrow(() -> new TechnologyNotFoundException("User has no associated technologies"));
    }

    public Technology addTechnology(Technology technology) {
        try {
            return technologyRepository.save(technology);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateTechnologyException("Technology already exists for this user");
        }
    }

    public void removeTechnology(Long technologyId) {
        technologyRepository.deleteById(technologyId);
    }
}
