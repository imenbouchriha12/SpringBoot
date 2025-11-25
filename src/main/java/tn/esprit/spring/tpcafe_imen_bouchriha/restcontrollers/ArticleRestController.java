package tn.esprit.spring.tpcafe_imen_bouchriha.restcontrollers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Adresse;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Promotion;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.ArticleRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.services.articleservices.IArticleService;

import java.util.List;

@RestController
@RequestMapping("/articles")
@Tag(name = "Article Management API", description = "Permet de gérer les articles (CRUD complet).")
@AllArgsConstructor
public class ArticleRestController {

    private IArticleService articleService;
    @Operation(
            summary = "Afficher tous les articles",
            description = "Retourne la liste complète des articles enregistrés dans la base de données."
    )
    @GetMapping
    public List<Article> findAllArticles() {
        return articleService.findAllArticles();
    }

    @Operation(
            summary = "Ajouter un nouvel article",
            description = "Ajoute un article dans la base de données en envoyant un objet JSON dans le corps de la requête."
    )
    @PostMapping("/addArticle")
    public Article addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @Operation(
            summary = "Ajouter Plusieurs articles",
            description = "Ajoute des articles dans la base de données en envoyant un objet JSON dans le corps de la requête."
    )
    @PostMapping("/addArticles")
    public List<Article> addArticles(@RequestBody List<Article> Articles) {
        return articleService.saveArticles(Articles);
    }

    @Operation(
            summary = "Afficher un article par ID",
            description = "Recherche un article spécifique à partir de son identifiant (ID)."
    )
    @GetMapping ("selectbyid/{id}")
    public Article selectArticleById(@PathVariable long id) {
        return articleService.selectArticleByIdWithOeElse(id);
    }

    @Operation(
            summary = "Afficher un article par ID",
            description = "Recherche un article spécifique à partir de son identifiant (ID)."
    )
    @GetMapping ("selectbyid")
    public Article selectArticleById2(@RequestParam long id) {
        return articleService.selectArticleByIdWithOeElse(id);
    }

    @Operation(
            summary = "Supprimer un article par ID",
            description = "Supprime un article spécifique en utilisant son identifiant (ID)."
    )
    @DeleteMapping("deleteArticleById")
    public void deleteArticleById(@RequestParam long id)
    {
        articleService.deleteArticleById(id);
    }

    @Operation(
            summary = "Supprimer tous les articles",
            description = "Supprime tous les articles de la base de données."
    )
    @DeleteMapping("/DleteAllArticles")
    public void deleteAllArticles(){
        articleService.deleteAllArticles();
    }
    @DeleteMapping("/DeleteArticle")
    public void deleteArticle(Article article){
        articleService.deleteArticle(article);
    }

    @PostMapping("/add-with-promotions")
    public ResponseEntity<Article> ajouterArticleEtPromotions(@RequestBody Article article) {
        Article savedArticle = articleService.ajouterArticleEtPromotions(article);
        return ResponseEntity.ok(savedArticle);
    }
    @PostMapping("/affecter-promo/{idArticle}/{idPromo}")
    public ResponseEntity<String> affecterPromotionAArticle(
            @PathVariable Long idArticle,
            @PathVariable Long idPromo) {
        articleService.affecterPromotionAArticle(idArticle, idPromo);
        return ResponseEntity.ok("Promotion affectée à l'article avec succès");
    }

    @DeleteMapping("/desaffecter-promo/{idArticle}/{idPromo}")
    public ResponseEntity<String> desaffecterPromotionDUnArticle(
            @PathVariable Long idArticle,
            @PathVariable Long idPromo) {
        articleService.desaffecterPromotionDUnArticle(idArticle, idPromo);
        return ResponseEntity.ok("Promotion désaffectée de l'article avec succès");
    }

    @PostMapping("/add-promo-to-article/{idArticle}")
    public ResponseEntity<String> ajouterPromoEtAffecterAArticle(
            @RequestBody Promotion promotion,
            @PathVariable Long idArticle) {

        articleService.ajouterPromoEtAffecterAArticle(promotion, idArticle);

        return ResponseEntity.ok("Promotion ajoutée et affectée à l'article avec succès");
    }

}
