package com.breathe.breatheApi.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Base {
    @Column(name = "full_name")
    private String name;

    @Column(name = "bio")
    private String bio;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "image_url")
    private String image_url;

    @OneToMany(mappedBy = "primaryInstructor")
    @JsonIgnoreProperties("primaryInstructor")
    private List<Workshop> workshops;
}
