package tn.esprit.spring.tpcafe_imen_bouchriha.services.promtionservices;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Promotion;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.ArticleRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.PromotionRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class PromotionService implements    IPromotionService{
    PromotionRepository promotionRepository;
    ArticleRepository articleRepository;
    @Override
    public Promotion addPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> savePromotions(List<Promotion> promotions) {
        return promotionRepository.saveAll(promotions);
    }

    @Override
    public Promotion selectPromotionByIdWithOeElse(long id) {
            return promotionRepository.findById(id).get();
    }

    @Override
    public List<Promotion> findAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public void deletePromotion(Promotion promotion) {
        promotionRepository.delete(promotion);
    }

    @Override
    public void deleteAllPromotions() {
        promotionRepository.deleteAll();
    }

    @Override
    public void deletePromotionById(long id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public long countPromotions() {
        return  promotionRepository.count();
    }

    @Override
    public boolean existsById(long id) {
        return promotionRepository.existsById(id);
    }


}
