package com.example.Tuan3.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name= "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "Name musst be less than 50 characrters")
    @NotBlank(message = "Name is requires")
    @Column(name= "name", length = 50, nullable = false)
    private String name;

    @Size(max = 250, message = "Decription must be less than 250 characters")
    @Column(name = "decription", length = 250)
    private String decription;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
