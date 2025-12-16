package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Adresse;

import java.util.List;
import java.util.Optional;

public interface AdresseRepository extends JpaRepository<Adresse,Long> {
    Optional<Adresse> findByRue(String rue);
    //KEYWORD
    //1
    List<Adresse> findByVille(String ville);
    //2
    List<Adresse> findByCodePostal(int codePostal);
    //3
    int countByVille(String ville);
    //4
    void deleteByVille(String ville);
    //5
    List<Adresse> findByVilleAndCodePostal(String ville,int codePostal);
    //6
    List<Adresse> findByRueCountainesAndVilleIgnoreCase(String rue,String ville);
    //7
    List<Adresse> findByVilleIn(List<String> villes);
    //8
    List<Adresse> findByCodePostalBetween(int codePostal1, int codePostal2);
    //9
    List<Adresse> findByCodePostalGraterThan(int codePostal1);
    //10
    List<Adresse> findByCodePostalGraterThanOrEqual(int codePostal1);
    //11
    List<Adresse> findByCodePostalLessThan(int codePostal1);
    //12
    List<Adresse> findByCodePostalLessThanOrEqual(int codePostal1);
    //13
    List<Adresse> findByRueStartsWithAndVilleOrderByCodePostal(String rue, String ville);
    //14
    List<Adresse> findByRueStartsWith(String rue);
    //15
    List<Adresse> findByVilleEndsWith(String ville);
    //16
    List<Adresse> findByRueIsNull();
    //17
    List<Adresse> findByVilleIsNotNull();

}
