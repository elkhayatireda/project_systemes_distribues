package mostapha.bayi.ebankservice.services;

import mostapha.bayi.ebankservice.entities.BankAccount;
import mostapha.bayi.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EbankService {
    private BankAccountRepository bankAccountRepository;

    public EbankService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }
    public BankAccount getBankAccountById( String id) {
        return bankAccountRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Bank account not found"));
    }

    public BankAccount save(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }
}
