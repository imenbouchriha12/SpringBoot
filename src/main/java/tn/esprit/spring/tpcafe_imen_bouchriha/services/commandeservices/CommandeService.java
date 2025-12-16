package tn.esprit.spring.tpcafe_imen_bouchriha.services.commandeservices;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Commande;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.ClientRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.CommandeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {
    CommandeRepository commandeRepository;
    ClientRepository clientRepository;

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> saveCommandes(List<Commande> commandes) {
        return commandeRepository.saveAll(commandes);
    }

    @Override
    public Commande selectCommandeByIdWithOeElse(long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public List<Commande> findAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public void deleteCommande(Commande commande) {
        commandeRepository.delete(commande);
    }

    @Override
    public void deleteAllCommandes() {
        commandeRepository.deleteAll();
    }

    @Override
    public void deleteCommandeById(long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public long countCommandes() {
        return commandeRepository.count();
    }

    @Override
    public boolean verifCommandeById(long id) {
        return commandeRepository.existsById(id);
    }

    @Override
    public Commande selectCommandeById(long id) {
        return commandeRepository.findById(id).get();
    }


    @Override
    public void affecterCommandeAClient(LocalDate dateCommande, String nomClient, String prenomClient) {
        // 1- Recuperer les objets
        Commande comm = commandeRepository.getByDateCommande(dateCommande);
        Client cli = clientRepository.findByNomAndPrenom(nomClient, prenomClient);
        // 2- Parent ? Commande / Child ? Client
        // 3- On affecte child a parent
        comm.setClient(cli);
        // 4- Persistance de L'affectation (save du parent)
        commandeRepository.save(comm);
    }

    @Override
    public void affecterCommandeAClient(Long idCommande, Long idClient) {
        // 1- Recuperer Les objets
        Commande comm = commandeRepository.findById(idCommande).get();
        Client cli = clientRepository.findById(idClient).get();
        // 2- Parent ? Commande / Child ? Client
        // 3- On affecte Child a parent
        comm.setClient(cli);
        // 4- Persistance de l'affectation (save du parent)
        commandeRepository.save(comm);
    }




    @Override
    public void desaffecterClientDeCommande(long idCommande) {
        // Recuperer Les objets
        Commande comm = commandeRepository.findById(idCommande).get();
        //parent=commande child= client
        // Désaffecter le client
        comm.setClient(null);

        // preisister
        commandeRepository.save(comm);

    }


  /*  @Override
    public void ajouterCommandeEtAffecterAClient(Commande c, String nomClient, String prenomClient) {

        Client client = clientRepository.findByNomAndPrenom(nomClient, prenomClient);
        c.setClient(client);
        client.getCommandes().add(c);

        commandeRepository.save(c);
    }*/

    @Override
    public Commande ajouterCommandeEtAffecterAClient(Commande c, String nomC, String prenomC) {
        // Chercher le client par nom et prénom
        Client client = clientRepository.findByNomAndPrenom(nomC, prenomC);

        // Affecter la commande au client
        c.setClient(client);

        // Sauvegarder la commande
        return commandeRepository.save(c);
    }
}