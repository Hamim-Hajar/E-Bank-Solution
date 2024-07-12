package com.example.Ebanksolotion.Repository;

import com.example.Ebanksolotion.Entity.Compt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComptRepository extends JpaRepository<Compt, Integer> {
    Compt findAccountByRib(String rib);


}
