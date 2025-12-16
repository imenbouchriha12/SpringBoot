package tn.esprit.spring.tpcafe_imen_bouchriha.services.clientservices;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Adresse;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Commande;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.AdresseRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.CarteFideliteRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.ClientRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.CommandeRepository;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class ClientService implements IClientService {
    ClientRepository clientRepository;
    CommandeRepository commandeRepository;
    AdresseRepository adresseRepository;
    CarteFideliteRepository carteFideliteRepository;
    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> saveClients(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

    @Override
    public Client selectClientByIdWithOeElse(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Client client) {
    clientRepository.delete(client);
    }

    @Override
    public void deleteAllClients() {
   clientRepository.deleteAll();
    }

    @Override
    public void deleteClientById(long id) {
   clientRepository.deleteById(id);
    }

    @Override
    public long countClients() {
        return clientRepository.count();
    }

    @Override
    public boolean verifClientById(long id) {
        return clientRepository.existsById(id);
    }

    @Override
    public Client selectClientById(long id) {
        return clientRepository.findById(id).get();
    }



    @Override
    public Client ajouterClientEtCarteFidelite(Client client) {

        CarteFidelite carte = new CarteFidelite();
        carte.setPointsAccumules(0);
        carte.setDateCreation(LocalDate.now());
        carte.setClient(client); // relation vers client

        client.setCarteFidelite(carte); // relation vers carte

        return clientRepository.save(client);
    }

    @Transactional
    @Override
    public void deleteClientAndCard(Long idClient) {

        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        CarteFidelite carte = client.getCarteFidelite();

        if (carte != null) {

            carte.setClient(null);
            client.setCarteFidelite(null);
            carteFideliteRepository.delete(carte);
        }
        clientRepository.delete(client);
    }



    @Override
    public String affecterAdresseAClient(String rue,long cin){
        Adresse a = adresseRepository.findByRue(rue).get();
        Client c = clientRepository.findById(cin).get();
        a.setClient(c);
        clientRepository.save(c);
        return "affectation reussite";
    }



    // affecterCarteAClient
    @Override
    public void affecterCarteAClient(long idCarte, long idClient) {

        // 1. Récupérer les objets
        Client client = clientRepository.findById(idClient).orElse(null);
        CarteFidelite carte = carteFideliteRepository.findById(idCarte).orElse(null);
        

        // 3. Affecter la carte au client
        carte.setClient(client);
        carteFideliteRepository.save(carte);
    }

    @Override
    public void ajouterEtAffecterAdresseAClient(Adresse a, Client c) {
        // Lier l'adresse au client
        a.setClient(c);
        c.setAdresse(a);

        // Sauvegarder le client (cascade sauvegarde automatiquement l'adresse)
        clientRepository.save(c);
    }

}

