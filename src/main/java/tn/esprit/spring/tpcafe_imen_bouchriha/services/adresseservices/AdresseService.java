package tn.esprit.spring.tpcafe_imen_bouchriha.services.adresseservices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Adresse;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.AdresseRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.ClientRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class AdresseService implements IAdresseService{
    AdresseRepository adresserepository;
    ClientRepository clientrepository;

    @Override
    public Adresse addAdresse(Adresse adresse) {
        return adresserepository.save(adresse);
    }

    @Override
    public List<Adresse> saveAdresses(List<Adresse> adresses) {
        return adresserepository.saveAll(adresses);
    }

    @Override
    public Adresse selectAdresseByIdWithOeElse(long id) {
        return adresserepository.findById(id).get();
    }

    @Override
    public List<Adresse> findAllAdresses() {
        return adresserepository.findAll();
    }

    @Override
    public void deleteAdresse(Adresse adresse) {
      adresserepository.delete(adresse);
    }

    @Override
    public void deleteAllAdresses() {
      adresserepository.deleteAll();
    }

    @Override
    public void deleteAdresseById(long id) {
         adresserepository.deleteById(id);
    }

    @Override
    public long countAdresses() {
        return adresserepository.count();
    }

    @Override
    public boolean verifAdresseById(long id) {
        return adresserepository.existsById(id);
    }

    @Override
    public Adresse selectAdresseById(long id) {
        return adresserepository.findById(id).get();
    }

    @Override
    public Client ajouterClientEtAdresse(Client client, Adresse adresse) {
        // Associer l'adresse au client
        client.setAdresse(adresse);

        // Optionnel si relation bidirectionnelle
        adresse.setClient(client);

        // Sauvegarder le client (l'adresse sera sauvegardée automatiquement)
        return clientrepository.save(client);
    }

}
