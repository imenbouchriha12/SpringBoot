package tn.esprit.spring.imenbouchriha4twin6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.imenbouchriha4twin6.entities.User;

public interface UserRepositry extends JpaRepository<User,Long> {
}
