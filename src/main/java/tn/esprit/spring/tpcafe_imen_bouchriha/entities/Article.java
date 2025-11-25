package tn.esprit.spring.tpcafe_imen_bouchriha.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.enums.TypeArticle;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idArticle;
     String nomArticle;
     float prixArticle;
    @Enumerated(EnumType.STRING)
     TypeArticle typeArticle;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Promotion> promotions;
    @OneToMany(mappedBy = "article")
    List<Detail_Commande> detailCommandes;
}
