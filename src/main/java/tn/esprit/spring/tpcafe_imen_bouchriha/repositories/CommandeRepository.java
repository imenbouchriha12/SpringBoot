package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Commande;

import java.time.LocalDate;

public interface CommandeRepository extends JpaRepository<Commande,Long> {

    Commande getByDateCommande(LocalDate dateCommande);

}
