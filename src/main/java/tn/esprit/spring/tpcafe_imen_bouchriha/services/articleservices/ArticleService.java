package tn.esprit.spring.tpcafe_imen_bouchriha.services.articleservices;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Promotion;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.ArticleRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.PromotionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j

public class ArticleService implements  IArticleService{
    ArticleRepository articleRepository;
    PromotionRepository promotionRepository;
    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> saveArticles(List<Article> articles) {
        return articleRepository.saveAll(articles);
    }

    @Override
    public Article selectArticleByIdWithOeElse(long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void deleteArticle(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public void deleteAllArticles() {
    articleRepository.deleteAll();
    }

    @Override
    public void deleteArticleById(long id) {
     articleRepository.deleteById(id);
    }

    @Override
    public long countArticles() {
        return articleRepository.count();
    }

    @Override
    public boolean verifArticleById(long id) {
        return articleRepository.existsById(id);
    }

    @Override
    public Article selectArticleById(long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public Article ajouterArticleEtPromotions(Article article) {

        if (article.getPromotions() != null) {
            article.getPromotions().forEach(promo -> {
                // Initialiser la liste si null
                if (promo.getArticles() == null) {
                    promo.setArticles(new ArrayList<>());
                }

                // Ajouter l’article dans la promotion
                promo.getArticles().add(article);
            });
        }

        // Sauvegarder l’article
        return articleRepository.save(article);
    }

    //Bonus
    @Override
    public void affecterPromotionAArticle(long idArticle, long idPromo) {
        Promotion promotion = promotionRepository.findById(idPromo).get();
        Article article = articleRepository.findById(idArticle).get();


        article.getPromotions().add(promotion);

        articleRepository.save(article);
    }

    @Override
    public void desaffecterPromotionDUnArticle(long idArticle, long idPromo) {
        Article article = articleRepository.findById(idArticle).get();
        Promotion promotion = promotionRepository.findById(idPromo).get();
        article.getPromotions().remove(promotion);
        articleRepository.save(article);

    }

    @Override
    public void ajouterPromoEtAffecterAArticle(Promotion p, Long idArticle) {

        Article article = articleRepository.findById(idArticle).get();

        article.getPromotions().add(p);

        articleRepository.save(article);
    }

    @Transactional
    @Override
    public void deleteArticleAndPromotions(Long idArticle) {

        Article article = articleRepository.findById(idArticle)
                .orElseThrow(() -> new RuntimeException("Article introuvable"));

        if (article.getPromotions() != null) {
            article.getPromotions().forEach(promo -> {
                promo.getArticles().remove(article); // couper la relation

                // si tu veux supprimer la promotion complètement :
                if (promo.getArticles().isEmpty()) {
                    promotionRepository.delete(promo);
                }
            });

            article.getPromotions().clear();
        }

        articleRepository.delete(article);
    }

    @Scheduled(cron = "0 0 0 1 * *") // Exécution le 1er de chaque mois à minuit
    public void scheduledPromotionCheck() {

        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int year = today.getYear();

        log.info("Vérification automatique des promotions pour {}-{}", month, year);

        getArticlesWithPromotionThisMonth(month, year); // Appel normal
    }
    @Override
    public List<Article> getArticlesWithPromotionThisMonth(int month, int year) {

        List<Article> articles =
                articleRepository.findArticlesWithPromotionInCurrentMonth(month, year);

            log.info("Articles en promotion pour {}-{} :", month, year);
            articles.forEach(a ->
                    log.info("- {} (Prix: {})", a.getNomArticle(), a.getPrixArticle())
            );

        return articles;
    }





}
