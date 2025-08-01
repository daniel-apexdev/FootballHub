/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballbanter.footballhub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DanielAsamoah
 */
@Entity
public class Manager implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manager_name")
    private String name;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    private String nationality;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "image_url")
    private String managerImageUrl;

    @Column(name = "flag_url")
    private String nationalityFlagUrl;

    @Column(name = "preferred_formation")
    private String preferredFormation;

    private Integer titles;

    @Enumerated(EnumType.STRING)
    private ManagerStatus status;

    
    public enum ManagerStatus {
        ACTIVE,
        RETIRED,
        DECEASED
    }
}
