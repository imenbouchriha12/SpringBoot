package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Detail_Commande;

import java.util.List;

public interface Detail_CommandeRepository extends JpaRepository<Detail_Commande,Long> {

    // 1
    List<Detail_Commande> findByQuantiteArticle(Integer quantite);

    // 2
    List<Detail_Commande> findBySousTotalDetailArticle(Double sousTotal);

    // 3
    long countByQuantiteArticleGreaterThan(Integer quantite);

    // 4
    boolean existsBySousTotalDetailArticleGreaterThan(Double min);

    // 5
    List<Detail_Commande> findByQuantiteArticleBetweenAndSousTotalDetailArticleGreaterThan(
            Integer q1, Integer q2, Double sousTotalMin);

    // 6
    List<Detail_Commande> findBySousTotalDetailArticleBetweenOrderByQuantiteArticle(
            Double min, Double max);

    // 7
    List<Detail_Commande> findBySousTotalDetailArticleApresPromoBetween(Double min, Double max);

    // 8
    List<Detail_Commande> findByQuantiteArticleOrSousTotalDetailArticleGreaterThan(
            Integer quantite, Double sousTotalMin);

    // 9
    List<Detail_Commande> findTop5ByOrderBySousTotalDetailArticleDesc();

    // 10
    List<Detail_Commande> findByQuantiteArticleIsNull();

    // 11
    List<Detail_Commande> findBySousTotalDetailArticleApresPromoIsNotNull();

    // 12 JPQL
    @Query("SELECT dc FROM Detail_Commande dc " +
            "JOIN FETCH dc.commande " +
            "JOIN FETCH dc.article")
    List<Detail_Commande> findAllWithCommandeAndArticle();
}
