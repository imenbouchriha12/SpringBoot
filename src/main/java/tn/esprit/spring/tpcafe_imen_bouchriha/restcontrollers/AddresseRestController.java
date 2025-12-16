package tn.esprit.spring.tpcafe_imen_bouchriha.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Adresse;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.services.adresseservices.IAdresseService;
import tn.esprit.spring.tpcafe_imen_bouchriha.services.clientservices.IClientService;

import java.util.List;
@RestController
@RequestMapping("adresses")
@AllArgsConstructor
public class AddresseRestController {
    private IAdresseService adresseService;
    private IClientService clientService;

    @GetMapping
    public List<Adresse> selectAllAdresses() {
        return adresseService.findAllAdresses();
    }
    @PostMapping("/addAdresess")
    public List<Adresse> addAdresses(@RequestBody List<Adresse> Adresses) {
        return adresseService.saveAdresses( Adresses);
    }
    @PostMapping
    public Adresse addAdresse(@RequestBody Adresse adresse) {
        return adresseService.addAdresse(adresse);
    }
    @GetMapping ("selectbyid/{id}")
    public Adresse selectAdresseById(@PathVariable long id) {
        return adresseService.selectAdresseByIdWithOeElse(id);
    }

    @GetMapping ("selectbyid")
    public Adresse selectAdresseById2(@RequestParam long id) {
        return adresseService.selectAdresseByIdWithOeElse(id);
    }
    @DeleteMapping("deleteAdresseById")
    public void deleteAdresseById(@RequestParam long id)
    {
        adresseService.deleteAdresseById(id);
    }
    @DeleteMapping("/DleteAllAdresses")
    public void deleteAllAdresses(){
        adresseService.deleteAllAdresses();
    }
    @DeleteMapping("/DeleteAdresse")
        public void deleteAdresse(Adresse adresse){
        adresseService.deleteAdresse(adresse);
    }
    @GetMapping ("/countAdresses")
    public long countAdresses() {
        return adresseService.countAdresses();
    }
    @PostMapping("/verifAdresse")
    public boolean verifAdresseById(@RequestParam long id) {
        return adresseService.verifAdresseById(id);
    }

    @PostMapping("/add-client-with-adresse")
    public ResponseEntity<Client> addClientWithAdresse(@RequestBody Client client) {
        Client savedClient = adresseService.ajouterClientEtAdresse(
                client, client.getAdresse());
        return ResponseEntity.ok(savedClient);
    }




}
