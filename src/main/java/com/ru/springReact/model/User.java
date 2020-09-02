package com.ru.springReact.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "User")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "name")
    @ToString.Include
    @EqualsAndHashCode.Include
    private String name;

    @Column(name = "username")
    @ToString.Include
    @EqualsAndHashCode.Include
    private String username;

    @Column(name = "password")
    @ToString.Include
    @EqualsAndHashCode.Include
    private String password;

    @Enumerated(EnumType.STRING)
    @ToString.Include
    @EqualsAndHashCode.Include
    @Column(name = "role")
    private Role role;
}
