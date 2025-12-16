package tn.esprit.spring.tpcafe_imen_bouchriha.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class CarteFidelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCarteFidilite;

    int pointsAccumules;
    LocalDate dateCreation;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
