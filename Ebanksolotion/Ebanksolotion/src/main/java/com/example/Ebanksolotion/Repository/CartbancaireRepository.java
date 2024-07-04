package com.example.Ebanksolotion.Repository;

import com.example.Ebanksolotion.Entity.Cartbancaire;
import com.example.Ebanksolotion.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartbancaireRepository extends JpaRepository<Cartbancaire, Integer> {
}
