package com.breathe.breatheApi.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base {
    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String full_name;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;
}