package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;

import java.time.LocalDate;
import java.util.List;

public interface CarteFideliteRepository extends JpaRepository<CarteFidelite,Long> {
    //JPQL

    // 1
    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointsAccumules = :points")
    List<CarteFidelite> findByExactPoints(@Param("points") int points);

    // 2
    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.dateCreation = :date")
    List<CarteFidelite> findByCreationDate(@Param("date") LocalDate date);

    // 3
    @Query("SELECT COUNT(cf) FROM CarteFidelite cf WHERE cf.pointsAccumules > :points")
    long countByPointsGreaterThan(@Param("points") int points);

    // 4
    @Query("DELETE FROM CarteFidelite cf WHERE cf.dateCreation < :date")
    void deleteByDateBefore(@Param("date") LocalDate date);

    // 5
    @Query("""
           SELECT cf FROM CarteFidelite cf
           WHERE cf.pointsAccumules BETWEEN :min AND :max
             AND cf.dateCreation > :date
           """)
    List<CarteFidelite> findByPointsRangeAndCreatedAfter(@Param("min") int min,
                                                         @Param("max") int max,
                                                         @Param("date") LocalDate date);

    // 6
    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointsAccumules >= :points ORDER BY cf.dateCreation ASC")
    List<CarteFidelite> findAtLeastPointsOrderByDate(@Param("points") int points);

    // 7
    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.dateCreation BETWEEN :d1 AND :d2")
    List<CarteFidelite> findByDateBetween(@Param("d1") LocalDate d1,
                                          @Param("d2") LocalDate d2);

    // 8
    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointsAccumules < :points OR cf.dateCreation < :date")
    List<CarteFidelite> findByLowPointsOrCreatedBefore(@Param("points") int points,
                                                       @Param("date") LocalDate date);

    // 9
    @Query("""
           SELECT cf FROM CarteFidelite cf
           WHERE cf.pointsAccumules = (SELECT MAX(c.pointsAccumules) FROM CarteFidelite c)
           """)
    CarteFidelite findMaxPointsCard();

    // 10
    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.dateCreation IS NULL")
    List<CarteFidelite> findWithoutCreationDate();

    // 11
    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointsAccumules IS NOT NULL")
    List<CarteFidelite> findWithPoints();

    // 12
    @Query("""
           SELECT cf FROM CarteFidelite cf
           JOIN cf.client c
           WHERE c.nom = :nom AND c.prenom = :prenom
           """)
    List<CarteFidelite> findByClientName(@Param("nom") String nom,
                                         @Param("prenom") String prenom);

    // 13
    @Query("SELECT cf FROM CarteFidelite cf ORDER BY cf.pointsAccumules DESC")
    List<CarteFidelite> findTop5CardsByPoints();
}
