package mostapha.bayi.ebankservice.controllers;

import mostapha.bayi.ebankservice.entities.BankAccount;
import mostapha.bayi.ebankservice.services.EbankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EbankRestController {
    private EbankService ebankService;

    public EbankRestController(EbankService ebankService) {
        this.ebankService = ebankService;
    }

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts() {
        return ebankService.getAllBankAccounts();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return ebankService.getBankAccountById(id);
    }

    @GetMapping("/accounts")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        return ebankService.save(bankAccount);
    }
}
