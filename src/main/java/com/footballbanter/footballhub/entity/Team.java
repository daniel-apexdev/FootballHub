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

/**
 *
 * @author DanielAsamoah
 */
@Entity
public class Team implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @Column(name = "year_founded")
    private Integer yearFounded;
    
    @Column(name = "logo_url")
    private String logoUrl;
    
    @Column(name = "backdrop_url")
    private String backdropUrl;
    
    @Column(name = "team_color")
    private String teamColor;
    
    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;
    
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;
}
