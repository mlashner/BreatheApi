package com.breathe.breatheApi.core;

import com.breathe.breatheApi.enums.Location;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "workshops")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workshop {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "location")
    private String location;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "end_time")
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "workshop")
    @JsonIgnoreProperties("workshop")
    private List<Favorite> favorites;

    @ManyToOne
    @JoinColumn(name = "primary_instructor_id")
    @JsonIgnoreProperties("primaryWorkshops")
    private Teacher primaryInstructor;

    @Column(name = "co_teachers")
    private String coTeachers;
}