package com.breathe.breatheApi.services;

import com.breathe.breatheApi.core.Workshop;
import com.breathe.breatheApi.repositories.WorkshopRepository;
import org.hibernate.ObjectNotFoundException;
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
        return workshopRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Workshop.class, "Workshop not found for id :: " + id));
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
}
