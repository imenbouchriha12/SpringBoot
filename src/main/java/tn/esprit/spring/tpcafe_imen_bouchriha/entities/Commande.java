package tn.esprit.spring.tpcafe_imen_bouchriha.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.enums.StatusCommande;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int idCommande;
     LocalDate dateCommande;
     float totalCommande;
    @Enumerated(EnumType.STRING)
     StatusCommande statusCommande;
    @ManyToOne
    Client client;
    @OneToMany(mappedBy = "commande")
    List<Detail_Commande> detail_commande;




}
