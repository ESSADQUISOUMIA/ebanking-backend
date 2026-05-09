package org.essadqui.ebankingbackend.entities;

import lombok.Data;

@Data 
public class CurrentAccount  extends BankAccount {
    private double overDraft;
}
