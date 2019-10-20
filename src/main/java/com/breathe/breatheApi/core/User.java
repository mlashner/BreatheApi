package com.breathe.breatheApi.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base {
    @Column(name = "installation_id")
    private String installationId;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private Admin admin;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "primaryInstructor")
    @JsonIgnoreProperties("primaryInstructor")
    private List<Workshop> workshops;

    @OneToMany(mappedBy = "secondaryInstructor")
    @JsonIgnoreProperties("secondaryInstructor")
    private List<Workshop> secondaryWorkshops;
}