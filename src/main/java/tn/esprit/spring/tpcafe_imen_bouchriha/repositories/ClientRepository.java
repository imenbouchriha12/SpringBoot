package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByNomAndPrenom(String nom, String prenom);

}
