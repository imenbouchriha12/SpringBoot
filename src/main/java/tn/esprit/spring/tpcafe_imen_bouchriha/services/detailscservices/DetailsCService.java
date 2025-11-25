package tn.esprit.spring.tpcafe_imen_bouchriha.services.detailscservices;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Detail_Commande;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.Detail_CommandeRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class DetailsCService implements IDetailsCService{

    Detail_CommandeRepository detail_commandeRepository;
    @Override
    public Detail_Commande addDetail_Commande(Detail_Commande detail_commande) {
        return detail_commandeRepository.save(detail_commande);
    }

    @Override
    public List<Detail_Commande> saveDetail_Commandes(List<Detail_Commande> detail_commandes) {
        return detail_commandeRepository.saveAll(detail_commandes);
    }

    @Override
    public Detail_Commande selectDetail_CommandeByIdWithOeElse(long id) {
        return detail_commandeRepository.findById(id).get();
    }

    @Override
    public List<Detail_Commande> findAllDetail_Commandes() {
        return detail_commandeRepository.findAll();
    }

    @Override
    public void deleteDetail_Commande(Detail_Commande detail_commande) {
       detail_commandeRepository.delete(detail_commande);
    }

    @Override
    public void deleteAllDetail_Commandes() {
    detail_commandeRepository.deleteAll();
    }

    @Override
    public void deleteDetail_CommandeById(long id) {
     detail_commandeRepository.deleteById(id);
    }

    @Override
    public long countDetail_Commandes() {
        return detail_commandeRepository.count();
    }

    @Override
    public boolean verifDetail_CommandesById(long id) {
        return detail_commandeRepository.existsById(id);
    }

    @Override
    public Detail_Commande selectUserById(long id) {
        return detail_commandeRepository.findById(id).get();
    }
}
