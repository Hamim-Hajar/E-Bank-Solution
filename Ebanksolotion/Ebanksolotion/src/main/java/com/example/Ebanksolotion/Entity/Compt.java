package com.example.Ebanksolotion.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_compt;
    private String rib;
    private String type_compt;
    private Double solde;
    private Date date_creation;
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
