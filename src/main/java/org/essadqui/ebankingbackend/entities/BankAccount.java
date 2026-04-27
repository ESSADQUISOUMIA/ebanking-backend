package org.essadqui.ebankingbackend.entities;

import org.essadqui.ebankingbackend.enums.AccountStatus;

public class BankAccount {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
}
