package tn.esprit.spring.tpcafe_imen_bouchriha.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Detail_Commande;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Promotion;
import tn.esprit.spring.tpcafe_imen_bouchriha.services.promtionservices.IPromotionService;

import java.util.List;

@RestController
@RequestMapping("promotions")
@AllArgsConstructor

public class PromotionRestController {
    private IPromotionService PromotionService;
    @GetMapping
    public List<Promotion> selectAllPromotions() {
        return PromotionService.findAllPromotions();
    }
    @PostMapping("/addPromotions")
    public List<Promotion> addPromotions(@RequestBody List<Promotion> Promotions) {
        return PromotionService.savePromotions( Promotions);
    }

    @PostMapping("/addPromotion")
    public Promotion addPromotion(@RequestBody Promotion promotion) {
        return PromotionService.addPromotion(promotion);
    }

    @GetMapping ("selectbyid/{id}")
    public Promotion selectPromotionById(@PathVariable long id) {
        return PromotionService.selectPromotionByIdWithOeElse(id);
    }

    @GetMapping ("selectbyid")
    public Promotion selectPromotionById2(@RequestParam long id) {
        return PromotionService.selectPromotionByIdWithOeElse(id);
    }

    @DeleteMapping("deletePromotionbyid")
    public void deletePromotionById(@RequestParam long id)
    {
        PromotionService.deletePromotionById(id);
    }

    @DeleteMapping("/DleteAllPromotions")
    public void deleteAllPromotions(){
        PromotionService.deleteAllPromotions();
    }

    @DeleteMapping("/DeletePromotion")
    public void deletePromotion(Promotion promotion){
        PromotionService.deletePromotion(promotion);
    }
}
