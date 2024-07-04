package com.example.Ebanksolotion.Repository;

import com.example.Ebanksolotion.Entity.Beneficiaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenificierRepository extends JpaRepository<Beneficiaires ,Integer> {
}
