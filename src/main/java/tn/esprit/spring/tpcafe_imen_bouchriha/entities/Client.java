package tn.esprit.spring.tpcafe_imen_bouchriha.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idCleint;
     String nom;
     String prenom;
     LocalDate dateNaissance;
    @OneToMany(mappedBy = "client")
    List<Commande> commandes;
    @OneToOne(cascade = CascadeType.ALL)
    private CarteFidelite carteFidelite;



}
