package com.breathe.breatheApi.core;

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
    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String full_name;

    @OneToOne(mappedBy = "user")
    private Admin admin;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "primaryInstructor")
    private List<Workshop> workshops;

    @OneToMany(mappedBy = "secondaryInstructor")
    private List<Workshop> secondaryWorkshops;
}