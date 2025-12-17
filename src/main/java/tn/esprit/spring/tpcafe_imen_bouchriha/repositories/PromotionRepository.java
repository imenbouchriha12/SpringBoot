package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}
