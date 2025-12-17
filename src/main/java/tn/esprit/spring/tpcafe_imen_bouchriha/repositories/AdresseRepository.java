package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Adresse;

import java.util.List;
import java.util.Optional;

public interface AdresseRepository extends JpaRepository<Adresse,Long> {
    Optional<Adresse> findByRue(String rue);
}
