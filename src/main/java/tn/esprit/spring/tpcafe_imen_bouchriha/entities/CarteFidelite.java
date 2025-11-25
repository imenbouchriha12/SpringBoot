package tn.esprit.spring.tpcafe_imen_bouchriha.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class CarteFidelite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idCarteFidilite;
     int pointsAccumules;
     LocalDate dateCreation;
    @OneToOne
    private Client client;



}
