/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballbanter.footballhub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DanielAsamoah
 */
@Entity
public class Player implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "dob")
    private LocalDate dob;

    private Integer age;
    private String nationality;
    private String position;

    @Column(name = "shirt_number")
    private Integer shirtNumber;

    @Column(name = "preferred_foot")
    private String preferredFoot;

    @Column(name = "market_value")
    private Double marketValue;

    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
