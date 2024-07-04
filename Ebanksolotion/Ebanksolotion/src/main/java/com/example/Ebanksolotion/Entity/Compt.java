package com.example.Ebanksolotion.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Compt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_compt;

    private String type_compt;
    private float solde;
    private LocalDateTime date_creation;
    private String raison_fermeture;
    @ManyToOne
    private User user;
    @OneToMany
    private Set<Cartbancaire> cartbancair;
    @OneToMany
    private Set<Beneficiaires> beneficiaires;
    @OneToMany
    private Set<Transaction> transactions;


}
