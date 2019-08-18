package com.breathe.breatheApi.controllers;

import com.breathe.breatheApi.core.Workshop;
import com.breathe.breatheApi.services.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/workshops")
public class WorkshopController {
    @Autowired
    private WorkshopService workshopService;

    @GetMapping
    public List<Workshop> getAllWorkshops() {
        return workshopService.findAll();
    }

    @GetMapping("/{id}")
    public Workshop getWorkshopById(@PathVariable(value = "id") Long id) {
        return workshopService.findById(id);
    }

    @PostMapping
    public Workshop createWorkshop(@Valid @RequestBody Workshop workshop) {
        return workshopService.createWorkshop(workshop);
    }

    @PutMapping("/{id}")
    public Workshop updateWorkshop(@PathVariable(value = "id") Long id, @Valid @RequestBody Workshop workshop) {
        return workshopService.updateWorkshop(id, workshop);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkshop(@PathVariable(value = "id") Long id) {
        workshopService.deleteWorkshop(id);
    }
}
