package tn.esprit.spring.tpcafe_imen_bouchriha.services.cartefservices;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Article;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.CarteFideliteRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.ClientRepository;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
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



    @Scheduled(cron = "0 0 0 * * *") // tous les jours à minuit
    public void incrementerPointsAnniversaire() {

        LocalDate today = LocalDate.now();

        // Récupérer uniquement les clients dont c’est l’anniversaire
        List<Client> clients = clientRepository.findClientsByAnniversaire(
                today.getDayOfMonth(),
                today.getMonthValue()
        );

        for (Client c : clients) {
            if (c.getCarteFidelite() != null) {

                double nouveauxPoints = c.getCarteFidelite().getPointsAccumules() * 1.10;
                int pointsArrondis = (int) nouveauxPoints;

                c.getCarteFidelite().setPointsAccumules(pointsArrondis);

                clientRepository.save(c);

                log.info("Anniversaire → Points fidélité augmentés pour {} {} | Nouveaux points = {}",
                        c.getNom(), c.getPrenom(), c.getCarteFidelite().getPointsAccumules());
            }
        }
    }
}
