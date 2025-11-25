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
public class Detail_Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idDetailCommande;
     int quantiteArticle;
     float sousTotalDetailArticle;
     float sousTotalDetailArticleApresPromo;

    @ManyToOne
    Commande commande;

    @ManyToOne
    Article article;
}
