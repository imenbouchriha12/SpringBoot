package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;

import java.time.LocalDate;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query("SELECT DISTINCT a FROM Article a JOIN a.promotions p " +
            "WHERE (MONTH(p.dateDebutPromo) = :currentMonth OR MONTH(p.dateFinPromo) = :currentMonth) " +
            "AND (YEAR(p.dateDebutPromo) = :currentYear OR YEAR(p.dateFinPromo) = :currentYear)")
    List<Article> findArticlesWithPromotionInCurrentMonth(@Param("currentMonth") int currentMonth,
                                                          @Param("currentYear") int currentYear);
}
