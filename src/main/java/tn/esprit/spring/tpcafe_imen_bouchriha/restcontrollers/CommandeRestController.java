package tn.esprit.spring.tpcafe_imen_bouchriha.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Commande;
import tn.esprit.spring.tpcafe_imen_bouchriha.services.commandeservices.ICommandeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("commandes")
@AllArgsConstructor

public class CommandeRestController {
    private ICommandeService CommandeService;
    @GetMapping
    public List<Commande> selectAllCommandes() {
        return CommandeService.findAllCommandes();
    }
    @PostMapping("/addcommandes")
    public List<Commande> addCommandes(@RequestBody List<Commande> clients) {
        return CommandeService.saveCommandes( clients);
    }

    @PostMapping("/addcommande")
    public Commande addCommande(@RequestBody Commande commande) {
        return CommandeService.addCommande(commande);
    }

    @GetMapping ("selectbyid/{id}")
    public Commande selectCommandeById(@PathVariable long id) {
        return CommandeService.selectCommandeByIdWithOeElse(id);
    }

    @GetMapping ("selectbyid")
    public Commande selectCommandeById2(@RequestParam long id) {
        return CommandeService.selectCommandeByIdWithOeElse(id);
    }

    @DeleteMapping("deleteCommandeById")
    public void deleteCommandeById(@RequestParam long id)
    {
        CommandeService.deleteCommandeById(id);
    }

    @DeleteMapping("/DleteAllCommandes")
    public void deleteAllCommandes(){
        CommandeService.deleteAllCommandes();
    }

    @DeleteMapping("/DeleteCommande")
    public void deleteCommande(Commande commande){
        CommandeService.deleteCommande(commande);
    }

    @PostMapping("/desaffecter-client")
    public ResponseEntity<String> desaffecterClientDeCommande(@RequestParam long idCommande) {
        CommandeService.desaffecterClientDeCommande(idCommande);
        return ResponseEntity.ok("Client désaffecté de la commande avec succès");
    }

    @PostMapping("/affecter-client")
    public ResponseEntity<String> affecterCommandeAClient(
            @RequestParam Long idCommande,
            @RequestParam Long idClient) {

        CommandeService.affecterCommandeAClient(idCommande, idClient);
        return ResponseEntity.ok("Commande affectée au client avec succès");
    }
    @PostMapping("/affecter-client-by-details")
    public ResponseEntity<String> affecterCommandeAClient(@RequestBody Map<String, String> body) {

        String dateStr = body.get("dateCommande");
        String nomClient = body.get("nomClient");
        String prenomClient = body.get("prenomClient");

        LocalDate dateCommande = LocalDate.parse(dateStr); // conversion String → LocalDate

        CommandeService.affecterCommandeAClient(dateCommande, nomClient, prenomClient);

        return ResponseEntity.ok("Commande affectée au client avec succès");
    }

    @PostMapping("/add/{nom}/{prenom}")
    public Commande addCommandeAndAffect(
            @RequestBody Commande commande,
            @PathVariable String nom,
            @PathVariable String prenom
    ) {
        CommandeService.ajouterCommandeEtAffecterAClient(commande, nom, prenom);
        return commande;
    }

}
