package org.essadqui.ebankingbackend.repositories;

import org.essadqui.ebankingbackend.entities.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingAccountRepository extends JpaRepository<SavingAccount, String> {
}
