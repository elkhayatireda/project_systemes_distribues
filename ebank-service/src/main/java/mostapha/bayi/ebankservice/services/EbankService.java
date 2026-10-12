package mostapha.bayi.ebankservice.services;

import mostapha.bayi.ebankservice.entities.BankAccount;
import mostapha.bayi.ebankservice.feign.CustomerRestClient;
import mostapha.bayi.ebankservice.model.Customer;
import mostapha.bayi.ebankservice.repository.BankAccountRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
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

    @McpTool(description = "Get all bank accounts")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @McpTool(description = "Get a bank account by id")
    public BankAccount getBankAccountById(@McpToolParam(description = "bank account id") String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Bank account not found"));
        bankAccount.setCustomer(
                customerRestClient.getCustomersById(bankAccount.getCustomerId()));
        return bankAccount;
    }

    @McpTool(description = "Save a new bank account")
    public BankAccount save(@McpToolParam(description = "the bank account to save (balance,type,customerId)") BankAccount bankAccount) {
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
