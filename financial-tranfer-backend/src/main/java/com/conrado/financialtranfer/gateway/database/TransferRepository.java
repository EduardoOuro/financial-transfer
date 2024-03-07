package com.conrado.financialtranfer.gateway.database;

import com.conrado.financialtranfer.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {}
