package tn.esprit.spring.tpcafe_imen_bouchriha.services.adresseservices;

import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Adresse;
import java.util.List;

public interface IAdresseService {
    Adresse addAdresse(Adresse adresse);
    List<Adresse> saveAdresses(List<Adresse> adresses);
    Adresse selectAdresseByIdWithOeElse(long id);
    List<Adresse> findAllAdresses();
    void deleteAdresse(Adresse adresse);
    void deleteAllAdresses();
    void deleteAdresseById(long id);
    long countAdresses();
    boolean verifAdresseById(long id);
    Adresse selectAdresseById(long id);


}

