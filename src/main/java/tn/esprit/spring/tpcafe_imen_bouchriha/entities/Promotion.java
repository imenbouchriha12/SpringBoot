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
//@RequiredArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int idPromotion;
     String pourcentagePromo;
     LocalDate dateDebutPromo;
     LocalDate dateFinPromo;
    @ManyToMany(mappedBy = "promotions")
    List<Article> articles;

}
