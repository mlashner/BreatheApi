package com.breathe.breatheApi.core;

import com.breathe.breatheApi.enums.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Workshops")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workshop extends Base {
    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private Location location;

    @Column(name = "description")
    private String description;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "workshop")
    private Set<Favorite> favorites;
}