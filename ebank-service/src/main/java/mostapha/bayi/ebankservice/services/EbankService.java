package mostapha.bayi.ebankservice.services;

import mostapha.bayi.ebankservice.entities.BankAccount;
import mostapha.bayi.ebankservice.feign.CustomerRestClient;
import mostapha.bayi.ebankservice.model.Customer;
import mostapha.bayi.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {
    private BankAccountRepository bankAccountRepository;

    private CustomerRestClient customerRestClient;
    public EbankService(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }
    public BankAccount getBankAccountById( String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Bank account not found"));
        bankAccount.setCustomer(
                customerRestClient.getCustomersById(bankAccount.getCustomerId()));
        return bankAccount;
    }

    public BankAccount save(BankAccount bankAccount) {
        try {
            Customer customer = customerRestClient.getCustomersById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return bankAccountRepository.save(bankAccount);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
