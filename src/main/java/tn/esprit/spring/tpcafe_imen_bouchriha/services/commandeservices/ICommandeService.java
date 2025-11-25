package tn.esprit.spring.tpcafe_imen_bouchriha.services.commandeservices;

import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Commande;

import java.time.LocalDate;
import java.util.List;

public interface ICommandeService {

    Commande addCommande(Commande commande);
    List<Commande> saveCommandes(List<Commande> commandes);
    Commande selectCommandeByIdWithOeElse(long id);
    List<Commande> findAllCommandes();
    void deleteCommande(Commande commande);
    void deleteAllCommandes();
    void deleteCommandeById(long id);
    long countCommandes();
    boolean verifCommandeById(long id);
    Commande selectCommandeById(long id);
    void affecterCommandeAClient(Long idCommande, Long idClient);
    void affecterCommandeAClient(LocalDate dateCommande, String nomClient, String prenomClient);
    void desaffecterClientDeCommande(long idCommande);
    void ajouterCommandeEtAffecterAClient(Commande c , String nomClient , String prenomClient );




}
