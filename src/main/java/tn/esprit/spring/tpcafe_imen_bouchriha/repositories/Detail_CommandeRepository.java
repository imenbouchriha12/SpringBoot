package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Detail_Commande;

import java.util.List;

public interface Detail_CommandeRepository extends JpaRepository<Detail_Commande,Long> {


}
