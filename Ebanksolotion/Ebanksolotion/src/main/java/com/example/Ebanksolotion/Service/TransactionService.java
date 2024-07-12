package com.example.Ebanksolotion.Service;

import com.example.Ebanksolotion.Entity.Beneficiaires;
import com.example.Ebanksolotion.Entity.Compt;
import com.example.Ebanksolotion.Entity.Transaction;
import com.example.Ebanksolotion.Repository.BenificierRepository;
import com.example.Ebanksolotion.Repository.ComptRepository;
import com.example.Ebanksolotion.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ComptRepository comptRepository;

    @Autowired
    private BenificierRepository benificierRepository;

    @Transactional
    public void transactionToInternAcc(Integer id_compt, String toAcc, float amount, String description) {
        Compt acc1 = comptRepository.findById(id_compt).orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (acc1.getSolde() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        Compt acc2 = comptRepository.findAccountByRib(toAcc);
        if (acc2 == null) {
            throw new IllegalArgumentException("Recipient account not found");
        }

        acc1.setSolde(acc1.getSolde() - amount);
        comptRepository.save(acc1);

        Transaction transactionDebit = new Transaction();
        transactionDebit.setDescription(description);
        transactionDebit.setTransactionType("Debit");
        transactionDebit.setAmount(amount);
        transactionDebit.setTrsferdate(LocalDateTime.now());
        transactionDebit.setCompt(acc1);
        transactionRepository.save(transactionDebit);

        acc2.setSolde(acc2.getSolde() + amount);
        comptRepository.save(acc2);

        Transaction transactionCredit = new Transaction();
        transactionCredit.setDescription(description);
        transactionCredit.setTransactionType("Credit");
        transactionCredit.setAmount(amount);
        transactionCredit.setTrsferdate(LocalDateTime.now());
        transactionCredit.setCompt(acc2);
        transactionRepository.save(transactionCredit);
    }

    @Transactional
    public void transactionToExternAcc(Integer id_compt, String benefNumber, float amount, String description) {
        Compt acc1 = comptRepository.findById(id_compt).orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (acc1.getSolde() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        Beneficiaires beneficiaire = benificierRepository.findBeneficiairesByComptRib(benefNumber);
        if (beneficiaire == null) {
            throw new IllegalArgumentException("Beneficiary account not found");
        }

        acc1.setSolde(acc1.getSolde() - amount);
        comptRepository.save(acc1);

        Transaction transactionDebit = new Transaction();
        transactionDebit.setDescription(description);
        transactionDebit.setTransactionType("Debit");
        transactionDebit.setAmount(amount);
        transactionDebit.setTrsferdate(LocalDateTime.now());
        transactionDebit.setCompt(acc1);
        transactionDebit.setBeneficiaires(beneficiaire);
        transactionRepository.save(transactionDebit);
    }
}
