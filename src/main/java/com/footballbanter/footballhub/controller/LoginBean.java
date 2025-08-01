/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballbanter.footballhub.controller;

import com.footballbanter.footballhub.entity.User;
import com.footballbanter.footballhub.entity.User.Role;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DanielAsamoah
 */
@Named
@SessionScoped
@Getter
@Setter
public class LoginBean implements Serializable {
    
    private String username;
    private String password;
    private boolean rememberMe;
    private User loggedUser;

    @PersistenceContext(unitName = "footballPU")
    private EntityManager em;

    public String login() {
        try {
            User user = em.createQuery(
                "SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                .setParameter("username", username)
                .setParameter("password", password) // NOTE: Hash in real apps
                .getSingleResult();

            loggedUser = user;
            
            if (rememberMe) {
                // e.g., save token in cookie or a longer session duration
            }
            
            return "/app/dashboard.xhtml?faces-redirect=true";

        } catch (NoResultException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Invalid credentials"));
            return null;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/app/login.xhtml?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return loggedUser != null;
    }

    public boolean isAdmin() {
        return isLoggedIn() && loggedUser.getRole() == Role.ADMIN;
    }
    
}
