package org.essadqui.ebankingbackend.web;

import lombok.AllArgsConstructor;
import org.essadqui.ebankingbackend.dtos.AccountHistoryDTO;
import org.essadqui.ebankingbackend.dtos.AccountOperationDTO;
import org.essadqui.ebankingbackend.dtos.BankAccountDTO;
import org.essadqui.ebankingbackend.entities.BankAccount;
import org.essadqui.ebankingbackend.exceptions.BalanceNotSufficientException;
import org.essadqui.ebankingbackend.exceptions.BankAccountNotFoundException;
import org.essadqui.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class BankAccountRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }

    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts(){
        return bankAccountService.bankAccountsList();
    }

    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "5") int size) throws BankAccountNotFoundException {

        return bankAccountService.getAccountHistory(accountId, page, size);
    }

    @PostMapping("/accounts/{accountId}/credit")
    public void credit(
            @PathVariable String accountId,
            @RequestParam(name = "amount", defaultValue = "0") double amount,
            @RequestParam(name= "description" , defaultValue = "") String description) throws BankAccountNotFoundException {
        bankAccountService.credit(accountId, amount, description);
    }

    @PostMapping("/accounts/{accountId}/debit")
    public void debit(
            @PathVariable String accountId,
            @RequestParam(name = "amount", defaultValue = "0") double amount,
            @RequestParam(name= "description" , defaultValue = "") String description) throws BankAccountNotFoundException, BalanceNotSufficientException {
        bankAccountService.debit(accountId, amount, description);
    }

    @PostMapping("/accounts/{accountIdSource}/transfer")
    public void transfer(
            @PathVariable String accountIdSource,
            @RequestParam String accountIdDestination,
            @RequestParam double amount) throws BankAccountNotFoundException, BalanceNotSufficientException {
        bankAccountService.transfer(accountIdSource, accountIdDestination, amount);
    }






}
