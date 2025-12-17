package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Detail_Commande;

public interface Detail_CommandeRepository extends JpaRepository<Detail_Commande,Long> {
}
