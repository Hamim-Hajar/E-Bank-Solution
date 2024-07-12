package com.example.Ebanksolotion.Repository;

import com.example.Ebanksolotion.Entity.Beneficiaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenificierRepository extends JpaRepository<Beneficiaires ,Integer> {
    @Query("SELECT b FROM Beneficiaires b WHERE b.compt.id_compt = :accountId")
    List<Beneficiaires> findAllByAccountId(@Param("accountId") Integer accountId);


   @Query(value ="select * from beneficiaires where account_number =?",nativeQuery = true)
    Beneficiaires findBeneficiairesByComptRib(String rib);
}
