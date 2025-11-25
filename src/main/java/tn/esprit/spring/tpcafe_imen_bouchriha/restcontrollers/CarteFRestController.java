package tn.esprit.spring.tpcafe_imen_bouchriha.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Adresse;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_imen_bouchriha.services.cartefservices.ICarteFService;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/cartesF")
public class CarteFRestController {
    private ICarteFService carteFService;
    @GetMapping
    public List<CarteFidelite> selectAllArticles() {
        return carteFService.findAllCarteFidelites();
    }
    @PostMapping("/addcartesF")
    public List<CarteFidelite> addCartsF(@RequestBody List<CarteFidelite> CarteFidelites) {
        return carteFService.saveCarteFidelites( CarteFidelites);
    }


    @PostMapping("/addcarteF")
    public CarteFidelite addCartF(@RequestBody CarteFidelite carteFidelite) {
        return carteFService.addCarteFidelite(carteFidelite);
    }

    @GetMapping ("selectbyid/{id}")
    public CarteFidelite selectCartFById(@PathVariable long id) {
        return carteFService.selectCarteFideliteByIdWithOeElse(id);
    }

    @GetMapping ("selectbyid")
    public CarteFidelite selectCartFById2(@RequestParam long id) {
        return carteFService.selectCarteFideliteByIdWithOeElse(id);
    }

    @DeleteMapping("deleteCarteFById")
    public void deleteCarteFById(@RequestParam long id)
    {
        carteFService.deleteCarteFideliteById(id);
    }

    @DeleteMapping("/DleteAllCartesF")
    public void deleteAllCartesF(){
        carteFService.deleteAllCarteFidelites();
    }

    @DeleteMapping("/DeleteCartesF")
    public void deleteCarteF(CarteFidelite carteFidelite){
        carteFService.deleteCarteFidelite(carteFidelite);
    }
}



