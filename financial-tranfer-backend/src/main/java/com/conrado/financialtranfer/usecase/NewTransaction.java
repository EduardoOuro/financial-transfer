package com.conrado.financialtranfer.usecase;

import com.conrado.financialtranfer.usecase.dto.TransactionDto;
import com.conrado.financialtranfer.usecase.dto.TransactionResultDto;

public interface NewTransaction {
    TransactionResultDto execute(TransactionDto dto);
}
