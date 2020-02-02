package com.breathe.breatheApi.repositories;

import com.breathe.breatheApi.BreatheApiApplicationTests;
import com.breathe.breatheApi.core.Teacher;
import com.breathe.breatheApi.core.Workshop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.*;

public class WorkshopRepositoryTest extends BreatheApiApplicationTests {
    @Autowired
    private WorkshopRepository workshopRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testCreate() {
        Workshop workshop = Workshop.builder()
                .id(1L)
                .title("Come Play With Me")
                .description("everybody happi")
                .startTime(LocalDateTime.of(2019, 7, 11, 11, 30))
                .endTime(LocalDateTime.of(2019, 7, 11, 13, 0))
                .build();
        Long id = workshopRepository.save(workshop).getId();

        Optional<Workshop> savedWorkshop = workshopRepository.findById(id);
        assertTrue(savedWorkshop.isPresent());
        assertEquals(savedWorkshop.get().getEndTime(), LocalDateTime.of(2019, 7, 11, 11, 30).plusMinutes(90));
    }

    @Test
    @Transactional
    public void testUpdate() {
        Workshop workshop = Workshop.builder()
                .id(1L)
                .title("Come Play With Me")
                .description("everybody happi")
                .startTime(LocalDateTime.of(2019, 7, 11, 11, 30))
                .endTime(LocalDateTime.of(2019, 7, 11, 13, 0))
                .build();
        Long id = workshopRepository.save(workshop).getId();

        Optional<Workshop> savedWorkshop = workshopRepository.findById(id);
        assertTrue(savedWorkshop.isPresent());

        Teacher teacher = Teacher.builder()
                .fullName("The Dude")
                .contactInfo("thedudeabides@bowling.us")
                .build();
        teacher = teacherRepository.save(teacher);

        savedWorkshop.get().setPrimaryInstructor(teacher);
        workshopRepository.save(savedWorkshop.get());

        Optional<Workshop> updatedWorkshop = workshopRepository.findById(id);
        assertTrue(updatedWorkshop.isPresent());
        assertEquals(updatedWorkshop.get().getPrimaryInstructor(), teacher);
    }

    @Test
    public void testDelete() {
        Workshop workshop = Workshop.builder()
                .id(1L)
                .title("Come Play With Me")
                .description("everybody happi")
                .startTime(LocalDateTime.of(2019, 7, 11, 11, 30))
                .endTime(LocalDateTime.of(2019, 7, 11, 13, 0))
                .build();
        Long id = workshopRepository.save(workshop).getId();

        Optional<Workshop> savedWorkshop = workshopRepository.findById(id);
        assertTrue(savedWorkshop.isPresent());

        workshopRepository.delete(savedWorkshop.get());
        Optional<Workshop> deletedWorkshop = workshopRepository.findById(id);
        assertFalse(deletedWorkshop.isPresent());
    }
}