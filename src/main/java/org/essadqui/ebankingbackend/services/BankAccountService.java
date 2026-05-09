package org.essadqui.ebankingbackend.services;

import org.essadqui.ebankingbackend.dtos.*;
import org.essadqui.ebankingbackend.entities.BankAccount;
import org.essadqui.ebankingbackend.entities.CurrentAccount;
import org.essadqui.ebankingbackend.entities.Customer;
import org.essadqui.ebankingbackend.entities.SavingAccount;
import org.essadqui.ebankingbackend.exceptions.BalanceNotSufficientException;
import org.essadqui.ebankingbackend.exceptions.BankAccountNotFoundException;
import org.essadqui.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;


public interface BankAccountService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO) ;

    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;

    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDescription, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;
    List<BankAccountDTO> bankAccountsList();
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}
