package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.enums.TypeArticle;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT c FROM Client c WHERE MONTH(c.dateNaissance) = :mois AND DAY(c.dateNaissance) = :jour")
    List<Client> findClientsByAnniversaire(@Param("jour") int jour, @Param("mois") int mois);

}
