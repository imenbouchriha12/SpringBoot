package tn.esprit.spring.tpcafe_imen_bouchriha.services.cartefservices;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.CarteFideliteRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.ClientRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class CarteFService implements ICarteFService{

    CarteFideliteRepository carteFideliteRepository;
    ClientRepository clientRepository;
    @Override
    public CarteFidelite addCarteFidelite(CarteFidelite carteFidelite) {
        return carteFideliteRepository.save(carteFidelite);
    }

    @Override
    public List<CarteFidelite> saveCarteFidelites(List<CarteFidelite> carteFidelites) {
        return carteFideliteRepository.saveAll(carteFidelites);
    }

    @Override
    public CarteFidelite selectCarteFideliteByIdWithOeElse(long id) {
        return carteFideliteRepository.findById(id).get();
    }

    @Override
    public List<CarteFidelite> findAllCarteFidelites() {
        return carteFideliteRepository.findAll();
    }

    @Override
    public void deleteCarteFidelite(CarteFidelite carteFidelite) {
     carteFideliteRepository.delete(carteFidelite);
    }

    @Override
    public void deleteAllCarteFidelites() {
   carteFideliteRepository.deleteAll();
    }

    @Override
    public void deleteCarteFideliteById(long id) {
      carteFideliteRepository.deleteById(id);
    }

    @Override
    public long countCarteFidelites() {
        return carteFideliteRepository.count();
    }

    @Override
    public boolean verifCarteFideliteById(long id) {
        return carteFideliteRepository.existsById(id);
    }

    @Override
    public CarteFidelite selectUserById(long id) {
        return carteFideliteRepository.findById(id).get();
    }

}
