package org.essadqui.ebankingbackend.entities;
import org.essadqui.ebankingbackend.enums.AccountStatus;
import java.util.List;
public class BankAccount {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private Customer customer;
    private List<AccountOpertion> accountOperations;


}
