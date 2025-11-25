package tn.esprit.spring.tpcafe_imen_bouchriha.services.articleservices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Promotion;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.ArticleRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.PromotionRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
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


}
