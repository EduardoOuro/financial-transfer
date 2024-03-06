package com.conrado.financialtranfer.usecase.impl;

import com.conrado.financialtranfer.usecase.FindAllTransaction;
import com.conrado.financialtranfer.usecase.dto.TransactionResultDto;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FindAllTransactionImpl implements FindAllTransaction {
    @Override
    public List<TransactionResultDto> execute(Long number) {
        System.out.println("AAAAAAA " + number);
        List<TransactionResultDto> resultList = new ArrayList<>();

        resultList.add(new TransactionResultDto(
                "ABCD",
                "DCBA",
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000),
                LocalDate.now(),
                LocalDate.now()
        ));

        resultList.add(new TransactionResultDto(
                "EFGH",
                "HGFE",
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000),
                LocalDate.now(),
                LocalDate.now()
        ));

        return resultList;
    }


}
