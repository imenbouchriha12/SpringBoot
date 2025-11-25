package tn.esprit.spring.tpcafe_imen_bouchriha.services.cartefservices;

import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;
import java.util.List;

public interface ICarteFService {

    CarteFidelite addCarteFidelite(CarteFidelite carteFidelite);
    List<CarteFidelite> saveCarteFidelites(List<CarteFidelite> carteFidelites);
    CarteFidelite selectCarteFideliteByIdWithOeElse(long id);
    List<CarteFidelite> findAllCarteFidelites();
    void deleteCarteFidelite(CarteFidelite carteFidelite);
    void deleteAllCarteFidelites();
    void deleteCarteFideliteById(long id);
    long countCarteFidelites();
    boolean verifCarteFideliteById(long id);
    CarteFidelite selectUserById(long id);


}
