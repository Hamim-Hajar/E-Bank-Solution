package com.example.Ebanksolotion.Controller;

import com.example.Ebanksolotion.Entity.Beneficiaires;
import com.example.Ebanksolotion.Service.BenificierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benificier")
public class BenificierController {
    @Autowired
    private BenificierService benificierService;

    @GetMapping("")
    public List<Beneficiaires> getAllBeneficiaries(@PathVariable Integer id_compt) {
        return benificierService.getAllBeneficiaries(id_compt);
    }

    @GetMapping("/{id}")
    public Beneficiaires getBeneficiaryById(@PathVariable Integer id) {
        return benificierService.getBeneficiaryById(id);
    }

    @PostMapping("/add")
    public Beneficiaires saveBeneficiary(@RequestBody Beneficiaires beneficiaires) {
        return benificierService.saveBeneficiary(beneficiaires);
    }

    @PutMapping("/update/{id_compt}")
    public Beneficiaires updateBeneficiary(@PathVariable Integer id_compt, @RequestBody Beneficiaires beneficiary) {
        return benificierService.UpdateBeneficiary(id_compt, beneficiary);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBeneficiary(@PathVariable Integer id) {
        benificierService.deleteBeneficiaire(id);
    }
}
