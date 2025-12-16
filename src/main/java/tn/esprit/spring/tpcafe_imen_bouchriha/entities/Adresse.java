package tn.esprit.spring.tpcafe_imen_bouchriha.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idAdresse;
     String rue;
     String ville;
     int codePostal;
    @OneToOne(mappedBy = "adresse")
    private Client client;

}
