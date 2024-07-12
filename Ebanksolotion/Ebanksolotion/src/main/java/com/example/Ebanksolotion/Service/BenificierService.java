package com.example.Ebanksolotion.Service;

import com.example.Ebanksolotion.Entity.Beneficiaires;
import com.example.Ebanksolotion.Entity.Compt;
import com.example.Ebanksolotion.Repository.BenificierRepository;
import com.example.Ebanksolotion.Repository.ComptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BenificierService {

    @Autowired
    private BenificierRepository benificierRepository;

    @Autowired
    private ComptRepository comptRepository;

    public List<Beneficiaires> getAllBeneficiaries(Integer id_compt) {
        return benificierRepository.findAllByAccountId(id_compt);
    }

    public Beneficiaires getBeneficiaryById(Integer id) {
        return benificierRepository.findById(id).orElse(null);
    }

    public Beneficiaires saveBeneficiary(Beneficiaires beneficiaires) {
        beneficiaires.setId_beneficiaire(null);
        return benificierRepository.save(beneficiaires);
    }

    public Beneficiaires UpdateBeneficiary(Integer accountId, Beneficiaires beneficiary) {
        Compt account = comptRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        beneficiary.setCompt(account);
        return benificierRepository.save(beneficiary);
    }

    public void deleteBeneficiaire(Integer id) {
        benificierRepository.deleteById(id);
    }
}
