package com.example.Ebanksolotion.Service;

import com.example.Ebanksolotion.Entity.Cartbancaire;
import com.example.Ebanksolotion.Entity.Compt;
import com.example.Ebanksolotion.Entity.User;
import com.example.Ebanksolotion.Repository.CartbancaireRepository;
import com.example.Ebanksolotion.Repository.ComptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CartbancaireService {
    @Autowired
    private CartbancaireRepository cartbancaireRepository;
    @Autowired
    private ComptRepository comptRepository;



    public void blockCard(Set<Cartbancaire> cartbancaires, String reason) {
        for(Cartbancaire cartbancaire : cartbancaires) {
            if (cartbancaire != null) {
                cartbancaire.setActive(false);
                cartbancaire.setBlockage_reason(reason);
                cartbancaireRepository.save(cartbancaire);
            } else {
                throw new RuntimeException("Card not found");
            }
        }


    }
}
