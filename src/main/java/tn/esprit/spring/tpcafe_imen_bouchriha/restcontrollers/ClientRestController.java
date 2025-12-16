package tn.esprit.spring.tpcafe_imen_bouchriha.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Adresse;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.services.clientservices.IClientService;

import java.util.List;
@RestController
@RequestMapping("clients")
@AllArgsConstructor

public class ClientRestController {
    private IClientService clientService;
    @GetMapping
    public List<Client> selectAllClients() {
        return clientService.findAllClients();
    }

    @PostMapping("/addclients")
    public List<Client> addClient(@RequestBody List<Client> clients) {
        return clientService.saveClients( clients);
    }

    @PostMapping("/addclient")
    public Client addCartF(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @GetMapping ("selectbyid/{id}")
    public Client selectclientById(@PathVariable long id) {
        return clientService.selectClientByIdWithOeElse(id);
    }

    @GetMapping ("selectbyid")
    public Client selectClientById2(@RequestParam long id) {
        return clientService.selectClientByIdWithOeElse(id);
    }

    @DeleteMapping("deleteClientById")
    public void deleteClientById(@RequestParam long id)
    {
        clientService.deleteClientById(id);
    }

    @DeleteMapping("/DleteAllClients")
    public void deleteAllClients(){
        clientService.deleteAllClients();
    }

    @DeleteMapping("/DeleteClient")
    public void deleteClient(Client client){
        clientService.deleteClient(client);
    }

    @PostMapping("/affecter-adresse")
    public ResponseEntity<String> affecterAdresseAClient(
            @RequestParam String rue,
            @RequestParam long cin) {

        String resultat = clientService.affecterAdresseAClient(rue, cin);
        return ResponseEntity.ok(resultat);
    }

    @PostMapping("/affecter-carte")
    public ResponseEntity<String> affecterCarteAClient(
            @RequestParam long idCarte,
            @RequestParam long idClient) {

        clientService.affecterCarteAClient(idCarte, idClient);
        return ResponseEntity.ok("Carte fidélité affectée au client avec succès");
    }


    @PostMapping("/add-with-carte")
    public ResponseEntity<Client> ajouterClientEtCarteFidelite(@RequestBody Client client) {
        Client savedClient = clientService.ajouterClientEtCarteFidelite(client);
        return ResponseEntity.ok(savedClient);
    }

    @DeleteMapping("/delete-client-with-carte/{idClient}")
    public ResponseEntity<String> deleteClientWithCarte(@PathVariable Long idClient) {

        clientService.deleteClientAndCard(idClient);

        return ResponseEntity.ok("Client et carte fidélité supprimés avec succès");
    }

    @PostMapping("/add-to-client")
    public ResponseEntity<String> ajouterAdresseAuClient(@RequestBody  Adresse a , Client c) {
        clientService.ajouterEtAffecterAdresseAClient(c.getAdresse(), a.getClient());
        return ResponseEntity.ok("Adresse ajoutée et affectée au client avec succès !");
    }


}
