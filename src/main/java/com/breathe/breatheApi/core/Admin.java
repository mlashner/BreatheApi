package com.breathe.breatheApi.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "admins")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Base {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "password_hash")
    private String passwordHash;
}
