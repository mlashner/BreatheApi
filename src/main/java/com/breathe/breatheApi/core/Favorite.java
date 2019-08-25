package com.breathe.breatheApi.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "hibernate.favorites")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorite extends Base {
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("favorites")
    private User user;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    @JsonIgnoreProperties("favorites")
    private Workshop workshop;
}