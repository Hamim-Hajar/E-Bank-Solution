package com.example.Ebanksolotion.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiaires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_beneficiaire;
    private String name;
    private Integer account_number;
    private String bank_name;
    @ManyToOne
    private Compt compt;
    @OneToMany
    private Set<Transaction> transactions;


}
