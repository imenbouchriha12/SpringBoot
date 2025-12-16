package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;

import java.time.LocalDate;
import java.util.List;

public interface CarteFideliteRepository extends JpaRepository<CarteFidelite,Long> {
    //JPQL

}
