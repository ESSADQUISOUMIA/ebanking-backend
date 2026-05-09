package org.essadqui.ebankingbackend.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.essadqui.ebankingbackend.entities.BankAccount;
import org.essadqui.ebankingbackend.enums.OperationType;

import java.util.Date;

@Data
public class AccountOperationDTO {

    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    String description;

}