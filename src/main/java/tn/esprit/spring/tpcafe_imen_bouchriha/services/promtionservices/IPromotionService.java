package tn.esprit.spring.tpcafe_imen_bouchriha.services.promtionservices;

import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Promotion;

import java.util.List;

public interface IPromotionService {

    Promotion addPromotion(Promotion promotion);
    List<Promotion> savePromotions(List<Promotion> promotions);
    Promotion selectPromotionByIdWithOeElse(long id);
    List<Promotion> findAllPromotions();
    void deletePromotion(Promotion promotion);
    void deleteAllPromotions();
    void deletePromotionById(long id);
    long countPromotions();
    boolean existsById(long id);

}
