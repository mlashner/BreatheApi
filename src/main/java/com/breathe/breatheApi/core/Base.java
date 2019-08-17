package com.breathe.breatheApi.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Base {
    @Id
    @GenericGenerator(name = "PER_ENTITY_GENERATOR", strategy = "enhanced-sequence", parameters = {
            @Parameter(name = "prefer_sequence_per_entity", value = "true")
    })
    @GeneratedValue(generator = "PER_ENTITY_GENERATOR")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
}