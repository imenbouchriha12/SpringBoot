package tn.esprit.spring.imenbouchriha4twin6.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id //clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
    @Column(name = "firstName")
     String nom;
    @Column(name = "lastName")
     String prenom;
    @Transient
     int age;
    @Temporal(TemporalType.DATE)
     Date dateAjout;
     LocalDate dateNaissance;
     long cin;
    @Enumerated(EnumType.STRING)
     Sexe sexe;
}
