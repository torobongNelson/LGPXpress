package org.smartapplication.repositories;

import org.smartapplication.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
}
