package com.munievents.munievents.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.munievents.munievents.entity.Plans;
import com.munievents.munievents.repository.PlansRepository;

@Service
public class PlansService {
    @Autowired
    PlansRepository plansRepository;

    public List<Plans> getPlans() {
        return plansRepository.findAll();
    }

    public Optional<Plans> getPlansById(Long plansId) {
        return plansRepository.findById(plansId);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Plans plans) {
        plansRepository.save(plans);
    }

    public void delete(Long plansId) {
        plansRepository.deleteById(plansId);
    }
    
}
