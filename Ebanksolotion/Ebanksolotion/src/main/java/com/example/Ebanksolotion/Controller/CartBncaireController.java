package com.example.Ebanksolotion.Controller;

import com.example.Ebanksolotion.Entity.Cartbancaire;
import com.example.Ebanksolotion.Service.CartbancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController("/card")
public class CartBncaireController {
    @Autowired
    CartbancaireService cartbancaireService;
    @PostMapping("/blockCard/{cardId}")
    public void blockCard(@PathVariable Set<Cartbancaire> cartbancaires, @RequestParam String reason) {
        cartbancaireService.blockCard(cartbancaires, reason);
    }
}
