package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Commande;

import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {

    Commande getByDateCommande(LocalDate dateCommande);
    //SQL
    // 1.
    @Query(value = "SELECT * FROM commande WHERE statut = :statut", nativeQuery = true)
    List<Commande> findByStatutSQL(@Param("statut") String statut);

    // 2
    @Query(value = "SELECT * FROM commande WHERE date_commande = :date", nativeQuery = true)
    List<Commande> findByExactDateSQL(@Param("date") LocalDate date);

    // 3
    @Query(value = "SELECT COUNT(*) FROM commande WHERE statut = :statut", nativeQuery = true)
    long countByStatutSQL(@Param("statut") String statut);

    // 4
    @Modifying
    @Query(value = "DELETE FROM commande WHERE date_commande < :date", nativeQuery = true)
    void deleteBeforeDateSQL(@Param("date") LocalDate date);

    // 5
    @Query(value = "SELECT * FROM commande WHERE date_commande BETWEEN :d1 AND :d2 AND statut = :statut", nativeQuery = true)
    List<Commande> findBetweenDatesAndStatutSQL(@Param("d1") LocalDate d1,
                                                @Param("d2") LocalDate d2,
                                                @Param("statut") String statut);

    // 6
    @Query(value = "SELECT * FROM commande WHERE total > :montant AND statut <> :statut", nativeQuery = true)
    List<Commande> findByTotalGreaterAndStatutNotSQL(@Param("montant") Double montant,
                                                     @Param("statut") String statut);

    // 7
    @Query(value = "SELECT * FROM commande WHERE statut IN (:statuts) ORDER BY date_commande", nativeQuery = true)
    List<Commande> findByStatutsOrderByDateSQL(@Param("statuts") List<String> statuts);

    // 8
    @Query(value = "SELECT * FROM commande WHERE date_commande < :date AND total BETWEEN :min AND :max", nativeQuery = true)
    List<Commande> findBeforeDateAndTotalBetweenSQL(@Param("date") LocalDate date,
                                                    @Param("min") Double min,
                                                    @Param("max") Double max);

    // 9
    @Query(value = "SELECT * FROM commande WHERE statut LIKE CONCAT('%', :suffix)", nativeQuery = true)
    List<Commande> findByStatutEndingWithSQL(@Param("suffix") String suffix);

    // 10
    @Query(value = "SELECT * FROM commande WHERE statut IS NULL", nativeQuery = true)
    List<Commande> findWithoutStatutSQL();

    // 11
    @Query(value = "SELECT * FROM commande WHERE total IS NOT NULL", nativeQuery = true)
    List<Commande> findWithTotalSQL();

    // 12
    @Query(value = """
        SELECT c.*, d.*, cl.*
        FROM commande c
        LEFT JOIN detail_commande d ON c.id = d.commande_id
        LEFT JOIN client cl ON c.client_id = cl.id
        """, nativeQuery = true)
    List<Object[]> findWithDetailsAndClientSQL();

    // 13
    @Query(value = "SELECT * FROM commande ORDER BY date_commande DESC LIMIT 3", nativeQuery = true)
    List<Commande> findTop3LatestSQL();
}
