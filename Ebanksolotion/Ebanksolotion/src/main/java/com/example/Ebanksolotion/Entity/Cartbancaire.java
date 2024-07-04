package com.example.Ebanksolotion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cartbancaire {
    @Id
    private String card_number;
    private String card_type;
    private Date expiration_date;
    private String blockage_reason;
    private boolean active;
    @ManyToOne
    private Compt compt;
}
