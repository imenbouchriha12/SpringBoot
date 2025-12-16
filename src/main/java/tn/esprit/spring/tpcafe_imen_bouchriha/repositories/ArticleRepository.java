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

    //JPQL
//1
    @Query("SELECT a FROM Article a WHERE a.nomArticle = :nom")
    List<Article> getArticlesByNom(@Param("nom") String nom);

    // 2
    @Query("SELECT a FROM Article a WHERE a.typeArticle = :type")
    List<Article> getArticlesByType(@Param("type") String type);

    // 3
    @Query("SELECT a FROM Article a WHERE a.prixArticle = :prix")
    List<Article> getArticlesByPrix(@Param("prix") float prix);

    // 4
    @Query("SELECT COUNT(a) > 0 FROM Article a WHERE a.nomArticle = :nom")
    boolean articleExistsByNom(@Param("nom") String nom);

    // 5
    @Query("SELECT COUNT(a) FROM Article a WHERE a.typeArticle = :type")
    long countArticlesByType(@Param("type") String type);

    // 6
    @Query("SELECT a FROM Article a WHERE a.nomArticle LIKE %:mot% AND a.typeArticle = :type")
    List<Article> searchByNomContainsAndType(@Param("mot") String mot,
                                             @Param("type") String type);

    // 7
    @Query("SELECT a FROM Article a WHERE a.prixArticle BETWEEN :min AND :max AND a.typeArticle IN :types")
    List<Article> getByPrixRangeAndTypes(@Param("min") float min,
                                         @Param("max") float max,
                                         @Param("types") List<String> types);

    // 8
    @Query("SELECT a FROM Article a WHERE LOWER(a.nomArticle) LIKE LOWER(CONCAT(:prefix, '%')) ORDER BY a.prixArticle ASC")
    List<Article> getByNomStartingWithOrderByPrix(@Param("prefix") String prefix);

    // 9
    @Query("""
           SELECT a FROM Article a 
           WHERE a.typeArticle = :type 
             AND a.prixArticle = (SELECT MAX(a2.prixArticle) FROM Article a2 WHERE a2.typeArticle = :type)
           """)
    List<Article> findMaxPrixByType(@Param("type") String type);

    // 10
    @Query("SELECT a FROM Article a WHERE a.nomArticle = :nom OR a.typeArticle = :type ORDER BY a.prixArticle DESC")
    List<Article> searchNomOrTypeOrderByPrix(@Param("nom") String nom,
                                             @Param("type") String type);

    // 11
    @Query("SELECT a FROM Article a WHERE a.nomArticle LIKE CONCAT(:prefix, '%')")
    List<Article> getByNomStartsWith(@Param("prefix") String prefix);

    // 12
    @Query("SELECT a FROM Article a WHERE a.nomArticle LIKE CONCAT('%', :suffix)")
    List<Article> getByNomEndsWith(@Param("suffix") String suffix);

    // 13
    @Query("SELECT a FROM Article a WHERE a.typeArticle IS NULL")
    List<Article> findWithoutType();

    // 14
    @Query("SELECT a FROM Article a WHERE a.prixArticle IS NOT NULL")
    List<Article> getArticlesWithPrix();

    // 15
    @Query("""
           SELECT a FROM Article a 
           JOIN a.promotions p 
           WHERE CURRENT_DATE BETWEEN p.dateDebutPromo AND p.dateFinPromo
           """)
    List<Article> getArticlesWithActivePromo();

    // 16
    @Query("SELECT a FROM Article a WHERE a.nomArticle LIKE %:chaine% AND a.prixArticle BETWEEN :min AND :max")
    List<Article> getByNomContainsAndPrix(@Param("chaine") String chaine,
                                          @Param("min") float min,
                                          @Param("max") float max);
}
