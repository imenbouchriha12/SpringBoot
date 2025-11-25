package tn.esprit.spring.tpcafe_imen_bouchriha.services.clientservices;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;

import java.util.List;

public interface IClientService {

    Client addClient(Client client);
    List<Client> saveClients(List<Client> clients);
    Client selectClientByIdWithOeElse(long id);
    List<Client> findAllClients();
    void deleteClient(Client client);
    void deleteAllClients();
    void deleteClientById(long id);
    long countClients();
    boolean verifClientById(long id);
    Client selectClientById(long id);
    Client ajouterClientEtCarteFidelite(Client client);
    String affecterAdresseAClient(String rue,long cin);
    void affecterCarteAClient(long idCarte, long idClient);


}
