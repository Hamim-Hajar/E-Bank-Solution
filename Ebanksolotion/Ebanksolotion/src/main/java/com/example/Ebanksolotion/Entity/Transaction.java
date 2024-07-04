package com.example.Ebanksolotion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    private Integer transactionId;
    private float amount;
    private String description;
    private String transactionType;
    private LocalDateTime trsferdate;

    @ManyToOne
    private Beneficiaires beneficiaires;
    @ManyToOne
    private Compt compt;
}
