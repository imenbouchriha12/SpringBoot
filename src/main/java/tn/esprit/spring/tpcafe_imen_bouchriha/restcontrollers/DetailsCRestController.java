package tn.esprit.spring.tpcafe_imen_bouchriha.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Detail_Commande;
import tn.esprit.spring.tpcafe_imen_bouchriha.services.detailscservices.IDetailsCService;

import java.util.List;

@RestController
@RequestMapping("detailsCommandes")
@AllArgsConstructor

public class DetailsCRestController {
    private IDetailsCService  detailsCService;
    @GetMapping
    public List<Detail_Commande> selectAllDetails() {
        return detailsCService.findAllDetail_Commandes();
    }

    @PostMapping("/addDetailsCs")
    public List<Detail_Commande> addDetailsC(@RequestBody List<Detail_Commande> Detail_Commandes) {
        return detailsCService.saveDetail_Commandes( Detail_Commandes);
    }

    @PostMapping("/addDetailsC")
    public Detail_Commande addDetailsC(@RequestBody Detail_Commande detailCommande) {
        return detailsCService.addDetail_Commande(detailCommande);
    }

    @GetMapping ("selectbyid/{id}")
    public Detail_Commande selectDetailsCommandeById(@PathVariable long id) {
        return detailsCService.selectDetail_CommandeByIdWithOeElse(id);
    }

    @GetMapping ("selectbyid")
    public Detail_Commande selectDetailsCommandeById2(@RequestParam long id) {
        return detailsCService.selectDetail_CommandeByIdWithOeElse(id);
    }

    @DeleteMapping("deleteDetailsF")
    public void deleteDetailsFById(@RequestParam long id)
    {
        detailsCService.deleteDetail_CommandeById(id);
    }

    @DeleteMapping("/DleteAllDetailsCById")
    public void deleteAllDetailsC(){
        detailsCService.deleteAllDetail_Commandes();
    }

    @DeleteMapping("/DeleteDetailsC")
    public void deleteDetailsC(Detail_Commande detailCommande){
        detailsCService.deleteDetail_Commande(detailCommande);
    }
}
