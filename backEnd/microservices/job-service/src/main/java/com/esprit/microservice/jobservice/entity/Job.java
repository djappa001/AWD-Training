package com.esprit.microservice.jobservice.entity;

import jakarta.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;
    private String description;
    private String entreprise;
    private String localisation;
    private Double salaire;

    // Constructeurs
    public Job() {
    }

    public Job(String titre, String description, String entreprise, String localisation, Double salaire) {
        this.titre = titre;
        this.description = description;
        this.entreprise = entreprise;
        this.localisation = localisation;
        this.salaire = salaire;
    }

    public Job(Integer id, String titre, String description, String entreprise, String localisation, Double salaire) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.entreprise = entreprise;
        this.localisation = localisation;
        this.salaire = salaire;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }
}
