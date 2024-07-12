package com.example.Ebanksolotion.Service;

import com.example.Ebanksolotion.Controller.CartBncaireController;
import com.example.Ebanksolotion.Entity.Cartbancaire;
import com.example.Ebanksolotion.Entity.Compt;
import com.example.Ebanksolotion.Entity.User;
import com.example.Ebanksolotion.Repository.CartbancaireRepository;
import com.example.Ebanksolotion.Repository.ComptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ComptService {
    @Autowired
    ComptRepository comptRepository;
    @Autowired
    CartbancaireRepository comptCartbancaireRepository;
    @Autowired
    private CartbancaireService cartbancaireService;
    @Autowired
    private CartbancaireRepository cartbancaireRepository;

    public Compt save(Compt compt) {
        return comptRepository.save(compt);
    }

    public Compt addAccount(String accountType, double initialBalance) {
        Compt compt = new Compt();
//        User user = new User();
        compt.setType_compt(accountType);
        compt.setSolde(initialBalance);
        compt.setDate_creation(new java.util.Date());
        compt.setRib(generateRIB());
        compt.setRaison_fermeture(compt.getRaison_fermeture());
//        user.setId_user(id);
//        compt.setUser(user);




        compt = comptRepository.save(compt);

        createCard(compt);

        return compt;
    }
//public Compt addAccount(String accountType, double initialBalance) {
//    Compt compt = new Compt();
//    compt.setType_compt(accountType);
//    compt.setSolde(initialBalance);
//    compt.setDate_creation(new java.util.Date());
//    compt.setRib(generateRIB());
//    compt.setRaison_fermeture(compt.getRaison_fermeture());
//
//    compt = comptRepository.save(compt);
//
//    createCard(compt, "Debit");
//
//    return compt;
//}
        public void createCard(Compt compt) {
        Cartbancaire cartbancair = new Cartbancaire();
        cartbancair.setCard_number(generateCardNumber());
        cartbancair.setExpiration_date(new Date(System.currentTimeMillis() + 31556952000L));
        cartbancair.setCard_type("Debit");
        cartbancair.setCompt(compt);

        comptCartbancaireRepository.save(cartbancair);
    }
//    public Cartbancaire createCard(Compt compt, String cardType) {
//        Cartbancaire cartbancair = new Cartbancaire();
//        cartbancair.setCard_number(generateCardNumber());
//        cartbancair.setExpiration_date(new Date(System.currentTimeMillis() + 31556952000L));
//        cartbancair.setCard_type(cardType);
//        cartbancair.setCompt(compt);
//
//      return   comptCartbancaireRepository.save(cartbancair);
//    }

    /*Cette fonction generateRIB() génère un RIB (Relevé d'Identité Bancaire) aléatoire.
    Un RIB est un identifiant unique pour un compte bancaire.
     La fonction génère un RIB de 24 chiffres */
    String generateRIB() {
// Crée une instance de la classe Random pour générer des nombres aléatoires
        Random random = new Random();
        // Initialise un StringBuilder pour construire la chaîne de caractères RIB
        StringBuilder rib = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            // Génère un nombre aléatoire entre 0 et 9 et l'ajoute au StringBuilder
            rib.append(random.nextInt(10));
        }
// Convertit le contenu du StringBuilder en une chaîne de caractères et la renvoie
        return rib.toString();
    }

    private String generateCardNumber() {

        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));
        }
        return cardNumber.toString();
    }

      public List<Compt> getComptList(){
          return comptRepository.findAll();
     }
     public Optional<Compt> getComptById(Integer id){
          return comptRepository.findById(id);
     }

     public void deleteCompt(Integer id, String reason){
        Compt compt = comptRepository.findById(id).get();
        cartbancaireService.blockCard(compt.getCartbancair(), reason);

        comptRepository.delete(compt);
     }

     public void updateCompt(Integer id,Compt compt){

          comptRepository.save(compt);
     }

    Compt createAccountForUser(User user) {
        Compt compt = new Compt();
        compt.setType_compt("Courant");
        compt.setSolde((double) 0);
        compt.setRib(generateRIB());
        compt.setUser(user);

        return compt;
    }

   }
