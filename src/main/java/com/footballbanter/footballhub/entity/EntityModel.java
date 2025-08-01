/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballbanter.footballhub.entity;

import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author DanielAsamoah
 */

@Getter
@Setter
@NoArgsConstructor
public class EntityModel implements Serializable{
    
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime createdBy;
    private boolean deleted;
    private String deletedBy;
}
