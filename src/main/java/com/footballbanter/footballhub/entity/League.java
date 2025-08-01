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
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DanielAsamoah
 */
@Entity
public class League implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "league_name")
    private String name;

    private String type;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_flag_url")
    private String countryFlagUrl;

    @Column(name = "trophy_url")
    private String trophyPictureUrl;

    @Column(name = "background_url")
    private String backgroundImageUrl;

    @OneToMany(mappedBy = "league")
    private List<Season> seasons;
    
    @OneToMany
    private List<Team> teams;
}
