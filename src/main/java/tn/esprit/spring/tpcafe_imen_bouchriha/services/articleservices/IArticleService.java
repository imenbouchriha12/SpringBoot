package tn.esprit.spring.tpcafe_imen_bouchriha.services.articleservices;

import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Commande;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Promotion;

import java.util.List;

public interface IArticleService {
    Article addArticle(Article article);
    List<Article> saveArticles(List<Article> articles);
    Article selectArticleByIdWithOeElse(long id);
    List<Article> findAllArticles();
    void deleteArticle(Article article);
    void deleteAllArticles();
    void deleteArticleById(long id);
    long countArticles();
    boolean verifArticleById(long id);
    Article selectArticleById(long id);
    Article ajouterArticleEtPromotions(Article article);
    void affecterPromotionAArticle(long idArticle, long idPromo);
    void desaffecterPromotionDUnArticle(long idArticle, long idPromo);
    void ajouterPromoEtAffecterAArticle(Promotion p , Long idArticle);
    void deleteArticleAndPromotions(Long idArticle);


    List<Article> getArticlesWithPromotionThisMonth(int month, int year);
}
