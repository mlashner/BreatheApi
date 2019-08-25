package com.breathe.breatheApi.services;

import com.breathe.breatheApi.core.Workshop;
import com.breathe.breatheApi.repositories.WorkshopRepository;
import com.breathe.breatheApi.utils.WorkshopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkshopService {
    @Autowired
    private WorkshopRepository workshopRepository;

    public List<Workshop> findAll() {
        return workshopRepository.findAll();
    }

    public Workshop findById(Long id) {
        return workshopRepository.findById(id).orElse(null);
    }

    public Workshop createWorkshop(Workshop workshop) {
        // TODO: check that workshop doesn't already exist
        return workshopRepository.save(workshop);
    }

    public Workshop updateWorkshop(Long id, Workshop workshop) {
        Workshop oldWorkshop = findById(id);
        oldWorkshop.setTitle(workshop.getTitle());
        oldWorkshop.setLocation(workshop.getLocation());
        oldWorkshop.setDescription(workshop.getDescription());
        oldWorkshop.setStartTime(workshop.getStartTime());
        oldWorkshop.setEndTime(workshop.getEndTime());
        oldWorkshop.setPrimaryInstructor(workshop.getPrimaryInstructor());
        oldWorkshop.setSecondaryInstructor(workshop.getSecondaryInstructor());
        return workshopRepository.save(oldWorkshop);
    }

    public void deleteWorkshop(Long id) {
        workshopRepository.delete(findById(id));
    }

    public void populateWorkshops() {
        workshopRepository.saveAll(WorkshopUtils.generateWorkshops());
        workshopRepository.flush();
    }
}
