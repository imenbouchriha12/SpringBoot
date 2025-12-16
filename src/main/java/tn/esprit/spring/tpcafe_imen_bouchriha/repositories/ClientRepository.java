package tn.esprit.spring.tpcafe_imen_bouchriha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.enums.TypeArticle;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT c FROM Client c WHERE MONTH(c.dateNaissance) = :mois AND DAY(c.dateNaissance) = :jour")
    List<Client> findClientsByAnniversaire(@Param("jour") int jour, @Param("mois") int mois);

    //KEYWORD
    //1
    List<Client> findByNom(String nom);
    //2
    List<Client> findByPrenom(String prenom);
    //3
    Client findByNomAndPrenom(String nom, String prenom);
    //4
    Boolean existsByNom(String nom);
    //5
    long findByDateNaissanceAfter(LocalDate date);
    //6
    List<Client> findByNomOrPrenomContaining(String nom, String prenom);
    //7
    List<Client> findByNomAndPrenomContaining(String nom, String prenom);
    //8
    List<Client> findByDateNaissanceBetween(LocalDate date1, LocalDate date2);
    //9
    List<Client> findByNomStartsWithAndDateNaissanceBefore(String nom, LocalDate date);
    //10
    List<Client> findByAdresse_Ville(String ville);
    //11
    List<Client> findByNomContainesOrderByPrenomAsc(String nom);
    //12
    List<Client> findByNomContainesOrderByPrenomDesc(String nom);
    //13
    List<Client> findByNomStartsWith(String nom);
    //14
    List<Client> findByPrenomEndsWith(String prenom);
    //15
    List<Client> findByDateNaissanceIsNull();
    //16
    List<Client> findByAdresseIsNotNull();
    //17
    List<Client> findByAdresse_VilleIn(List<String> villes);
    //18
    List<Client> findByCarteFidelite_PointsAccumulesGraterThan(int points);
    //19
    List<Client> findByCarteFidelite_PointsAccumulesGreaterThanEqual(int points);
    //20
    List<Client> findByCarteFidelite_PointsAccumulesBetween(int p1, int p2);
    //21
    List<Client> findByCommandes_DetailsCommande_Article_NomArticle(String nomArticle);
    //22
    List<Client> findByNomContainingAndCommandes_DetailsCommande_Article_TypeArticle(String nomPart, TypeArticle typeArticle);
}
