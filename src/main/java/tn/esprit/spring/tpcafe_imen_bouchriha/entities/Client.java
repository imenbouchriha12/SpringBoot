package tn.esprit.spring.tpcafe_imen_bouchriha.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCleint;

    String nom;
    String prenom;
    LocalDate dateNaissance;

    @OneToMany(mappedBy = "client")
    List<Commande> commandes;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore  // éviter boucle JSON
    private CarteFidelite carteFidelite;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;
}
