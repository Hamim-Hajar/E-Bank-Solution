package com.example.Ebanksolotion.Entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @Column(name = "amount")
    private float amount;

    @Column(name = "description")
    private String description;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "trsferdate")
    private LocalDateTime transferDate;

    @ManyToOne
    @JoinColumn(name = "beneficiaires_id_beneficiaire")
    private Beneficiaires beneficiaires;

    @ManyToOne
    @JoinColumn(name = "compt_id_compt")
    private Compt compt;

    public LocalDateTime setTrsferdate(LocalDateTime now) {
        return this.transferDate=transferDate;
    }
}
