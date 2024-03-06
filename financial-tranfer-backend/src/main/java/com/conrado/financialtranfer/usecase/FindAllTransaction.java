package com.conrado.financialtranfer.usecase;

import com.conrado.financialtranfer.usecase.dto.TransactionDto;
import com.conrado.financialtranfer.usecase.dto.TransactionResultDto;

import java.util.List;

public interface FindAllTransaction {
    List<TransactionResultDto> execute(Long number);
}
