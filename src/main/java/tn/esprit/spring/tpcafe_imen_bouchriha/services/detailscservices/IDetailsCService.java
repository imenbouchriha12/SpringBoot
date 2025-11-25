package tn.esprit.spring.tpcafe_imen_bouchriha.services.detailscservices;

import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Detail_Commande;


import java.util.List;
import java.util.Optional;

public interface IDetailsCService {

    Detail_Commande addDetail_Commande(Detail_Commande detail_commande);
    List<Detail_Commande> saveDetail_Commandes(List<Detail_Commande> detail_commandes);
    Detail_Commande selectDetail_CommandeByIdWithOeElse(long id);
    List<Detail_Commande> findAllDetail_Commandes();
    void deleteDetail_Commande(Detail_Commande detail_commande);
    void deleteAllDetail_Commandes();
    void deleteDetail_CommandeById(long id);
    long countDetail_Commandes();
    boolean verifDetail_CommandesById(long id);
    Detail_Commande selectUserById(long id);

}
