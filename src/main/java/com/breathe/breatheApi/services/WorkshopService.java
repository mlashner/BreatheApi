package com.breathe.breatheApi.services;

import com.breathe.breatheApi.core.Teacher;
import com.breathe.breatheApi.core.Workshop;
import com.breathe.breatheApi.enums.Location;
import com.breathe.breatheApi.enums.WorkshopType;
import com.breathe.breatheApi.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkshopService {
    @Autowired
    private WorkshopRepository workshopRepository;

    @Autowired
    private TeacherService teacherService;

    public List<Workshop> findAll() {
        return workshopRepository.findAll(Sort.by(Sort.Direction.ASC, "startTime"));
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
        oldWorkshop.setCoTeachers(workshop.getCoTeachers());
        return workshopRepository.save(oldWorkshop);
    }

    public void deleteWorkshop(Long id) {
        workshopRepository.delete(findById(id));
    }

    public void populateWorkshops() throws IOException {
        List<Workshop> workshops = readWorkshops();
        workshopRepository.saveAll(workshops);
        workshopRepository.flush();
    }

    private List<Workshop> readWorkshops() throws IOException {
        List<Workshop> workshops = new ArrayList<>();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("workshops_2023.tsv");
        BufferedReader csvReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String header = csvReader.readLine();
        String _appInfo_ = csvReader.readLine();
        String row = csvReader.readLine();
        while (row != null) {
            Workshop workshop = createWorkshopFromCsv(row, header);
            if (workshop != null) {
                workshops.add(workshop);
            }
            row = csvReader.readLine();
        }
        csvReader.close();
        return workshops;
    }

    private Workshop createWorkshopFromCsv(String row, String header) {
        String[] headerData = header.split("\t");
        String[] rowData = row.split("\t");

        Workshop workshop = new Workshop();
        Teacher teacher = new Teacher();

        for (int i = 0; i < headerData.length; i++) {
            switch (headerData[i]) {
                case "ID":
                    workshop.setId(Long.parseLong(rowData[i]));
                    break;
                case "CONFIRMED & BREATHE APP APPROVED":
                    if (!"Y".equals(rowData[i])) {
                        return null;
                    }
                    break;
                case "TYPE":
                    if (!rowData[i].isEmpty()) {
                        workshop.setType(WorkshopType.valueOf(rowData[i]
                                .replaceAll(" ", "_")
                                .replace("&", "AND")));
                    }
                    break;
                case "VENUE":
                    if (!rowData[i].isEmpty()) {
                        workshop.setLocation(Location.valueOf(rowData[i]
                                .replaceAll("[ -]", "_")
                                .replace("&", "AND")
                                .toUpperCase()));
                    }
                    break;
                case "Start Date & Time MM/DD/YYYY 12H":
                    workshop.setStartTime(parseDateTime(rowData[i]));
                    break;
                case "End Date & Time MM/DD/YYYY 12H":
                    workshop.setEndTime(parseDateTime(rowData[i]));
                    break;
                case "First & Last Name (Public Information)":
                    // create user or find if one exists
                    teacher = teacherService.getOrCreateTeacher(rowData[i]);
                    workshop.setPrimaryInstructor(teacher);
                    break;
                case "Contact Information (Public Information) Examples...website / social handles / business emails":
                    // add contact information to the user
                    if (teacher.getContactInfo() == null || teacher.getContactInfo().isEmpty()) {
                        teacher.setContactInfo(rowData[i]);
                    }
                    break;
                case "Teacher Bio (Public Information) Max 300 Words":
                    // add teacher bio to teacher (or workshop?)
                    if (teacher.getBio() == null || teacher.getBio().isEmpty()) {
                        teacher.setBio(rowData[i]);
                    }
                    break;
                case "CO-TEACHER(S) First & Last Name. Separate names by comma. Example.. John Smith, Jane Doe":
                    workshop.setCoTeachers(rowData[i]);
                    break;
                case "Workshop Title (ideally 3-12 words)":
                    workshop.setTitle(rowData[i]);
                    break;
                case "Workshop Description  (Max 200 Words)":
                    workshop.setDescription(rowData[i]);
                    break;
                case "Workshop Tags":
                    // add tags if it's a thing
                    break;
                case "UPLOAD IMAGES HERE":
                    // image url
                    // TODO: This will be taken care of in a separate image ingest
                    break;
            }
        }
        if (teacher.getId() != null) {
            teacherService.updateTeacher(teacher);
        }
        return workshop;
    }

    private LocalDateTime parseDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy h:mm a");
        return LocalDateTime.parse(dateTime, formatter);
    }
}
