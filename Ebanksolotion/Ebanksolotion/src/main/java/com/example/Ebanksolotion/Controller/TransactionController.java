package com.example.Ebanksolotion.Controller;

import com.example.Ebanksolotion.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/interne")
    public void makeInterneTransaction(@RequestBody Map<String, Object> transactionDetails) {
        Integer id_compt = (Integer) transactionDetails.get("id_compt");
        String toAcc = (String) transactionDetails.get("toAcc");
        Float amount = ((Number) transactionDetails.get("amount")).floatValue();
        String description = (String) transactionDetails.get("description");

        transactionService.transactionToInternAcc(id_compt, toAcc, amount, description);
    }

    @PostMapping("/externe")
    public void makeExterneTransaction(@RequestParam Integer id_compt,
                                       @RequestParam String benefAccNumber,
                                       @RequestParam float amount,
                                       @RequestParam String description) {
        transactionService.transactionToExternAcc(id_compt, benefAccNumber, amount, description);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException e) {
        return e.getMessage();
    }
}
