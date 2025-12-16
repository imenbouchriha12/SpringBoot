package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Promotion;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {

    //sql
    // 1
    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo = :pourcentage", nativeQuery = true)
    List<Promotion> findByPourcentageExactSQL(@Param("pourcentage") String pourcentage);

    // 2
    @Query(value = "SELECT * FROM promotion WHERE date_debut_promo = :date", nativeQuery = true)
    List<Promotion> findByDateDebutSQL(@Param("date") LocalDate date);

    // 3
    @Query(value = "SELECT * FROM promotion WHERE date_fin_promo = :date", nativeQuery = true)
    List<Promotion> findByDateFinSQL(@Param("date") LocalDate date);

    // 4
    @Query(value = "SELECT COUNT(*) > 0 FROM promotion WHERE pourcentage_promo = :pourcentage", nativeQuery = true)
    boolean existsByPourcentageSQL(@Param("pourcentage") String pourcentage);

    // 5
    @Query(value = "SELECT COUNT(*) FROM promotion WHERE date_debut_promo > :date", nativeQuery = true)
    long countStartingAfterSQL(@Param("date") LocalDate date);

    // 6
    @Query(value = "SELECT * FROM promotion WHERE date_debut_promo <= :date AND date_fin_promo >= :date", nativeQuery = true)
    List<Promotion> findActiveAtDateSQL(@Param("date") LocalDate date);

    // 7
    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo = :pourcentage AND date_debut_promo BETWEEN :d1 AND :d2", nativeQuery = true)
    List<Promotion> findByPourcentageAndStartBetweenSQL(@Param("pourcentage") String pourcentage,
                                                        @Param("d1") LocalDate d1,
                                                        @Param("d2") LocalDate d2);

    // 8
    @Query(value = "SELECT * FROM promotion WHERE :date BETWEEN date_debut_promo AND date_fin_promo", nativeQuery = true)
    List<Promotion> findValidAtDateSQL(@Param("date") LocalDate date);

    // 9
    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo IN (:pourcentages) ORDER BY date_debut_promo", nativeQuery = true)
    List<Promotion> findByPourcentagesOrderByStartSQL(@Param("pourcentages") List<String> pourcentages);

    // 10
    @Query(value = "SELECT * FROM promotion WHERE date_fin_promo >= CURRENT_DATE ORDER BY pourcentage_promo", nativeQuery = true)
    List<Promotion> findActiveOrderByPourcentageSQL();

    // 11
    @Query(value = "SELECT * FROM promotion WHERE date_fin_promo IS NULL", nativeQuery = true)
    List<Promotion> findWithoutEndDateSQL();

    // 12
    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo IS NOT NULL", nativeQuery = true)
    List<Promotion> findWithPourcentageSQL();

    // 13
    @Query(value = """
        SELECT p.*, a.*
        FROM promotion p
        LEFT JOIN article_promotion ap ON p.id_promotion = ap.promotion_id
        LEFT JOIN article a ON a.id_article = ap.article_id
        """, nativeQuery = true)
    List<Object[]> findPromotionsWithArticlesSQL();

    // 14
    @Query(value = "SELECT * FROM promotion WHERE date_fin_promo < CURRENT_DATE", nativeQuery = true)
    List<Promotion> findExpiredSQL();
}
