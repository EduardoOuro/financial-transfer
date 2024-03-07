package com.conrado.financialtranfer.usecase.impl;

import com.conrado.financialtranfer.domain.Transfer;
import com.conrado.financialtranfer.gateway.database.TransferRepository;
import com.conrado.financialtranfer.usecase.FindAllTransaction;
import com.conrado.financialtranfer.usecase.dto.TransactionResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FindAllTransactionImpl implements FindAllTransaction {

    private final TransferRepository transferRepository;

    @Autowired
    public FindAllTransactionImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }
    @Override
    public List<TransactionResultDto> execute(Long number) {
        List<TransactionResultDto> resultList = new ArrayList<>();

        resultList.add(new TransactionResultDto(
                "ABCD",
                "DCBA",
                BigDecimal.valueOf(1000).setScale(2, RoundingMode.HALF_UP),
                BigDecimal.valueOf(1000).setScale(2, RoundingMode.HALF_UP),
                LocalDate.now(),
                LocalDate.now()
        ));

        resultList.add(new TransactionResultDto(
                "EFGH",
                "HGFE",
                BigDecimal.valueOf(1000).setScale(2, RoundingMode.HALF_UP),
                BigDecimal.valueOf(1000).setScale(2, RoundingMode.HALF_UP),
                LocalDate.now(),
                LocalDate.now()
        ));

        return resultList;
    }


//    @Override
//    public List<TransactionResultDto> execute(Long number) {
//        Iterable<Transfer> transfers = transferRepository.findAll();
//        List<TransactionResultDto> resultList = new ArrayList<>();
//
//        for (Transfer transfer : transfers) {
//            TransactionResultDto transactionResultDto = new TransactionResultDto(
//                    transfer.getContaOrigem(),
//                    transfer.getContaDestino(),
//                    transfer.getValorTransferencia(),
//                    transfer.getTaxa(),
//                    transfer.getDataTransferencia(),
//                    transfer.getDataAgendamento()
//            );
//            resultList.add(transactionResultDto);
//        }
//
//        return resultList;
//    }




}
