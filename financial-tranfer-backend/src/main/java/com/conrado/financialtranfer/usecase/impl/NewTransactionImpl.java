package com.conrado.financialtranfer.usecase.impl;

import com.conrado.financialtranfer.usecase.NewTransaction;
import com.conrado.financialtranfer.usecase.dto.TransactionDto;
import com.conrado.financialtranfer.usecase.dto.TransactionResultDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class NewTransactionImpl implements NewTransaction {
    @Override
    public TransactionResultDto execute(TransactionDto dto) {
        final BigDecimal NO_FEE = BigDecimal.valueOf(-1.00);

        BigDecimal valueFee = calculateTransferFee(dto.getAmount(), dto.getTransferDate());


        if(valueFee.longValue() == -1L) {
            throw new IllegalArgumentException("Transferência não permitida: taxa não aplicável.");
        } else {
            return new TransactionResultDto(
                    dto.getSourceAccount(),
                    dto.getDestinationAccount(),
                    dto.getAmount(),
                    valueFee,
                    dto.getTransferDate(),
                    LocalDate.now()
            );
        }

    }

    public static BigDecimal calculateTransferFee(BigDecimal amount, LocalDate transferDate) {
        BigDecimal valueFee = BigDecimal.ZERO;


        long daysUntilTransfer = ChronoUnit.DAYS.between(LocalDate.now(), transferDate);

        if (daysUntilTransfer == 0) {
            valueFee = BigDecimal.valueOf(3.00);
            valueFee = valueFee.add(amount.multiply(BigDecimal.valueOf(0.025)));


        } else if (daysUntilTransfer >= 0 && daysUntilTransfer <= 10) {
            valueFee = BigDecimal.valueOf(12.00);
            valueFee = valueFee.add(amount.multiply(BigDecimal.valueOf(0.025)));

        } else if (daysUntilTransfer >= 11 && daysUntilTransfer <= 20) {
            valueFee = amount.multiply(BigDecimal.valueOf(0.082));

        } else if (daysUntilTransfer >= 21 && daysUntilTransfer <= 30) {
            valueFee = amount.multiply(BigDecimal.valueOf(0.069));

        } else if (daysUntilTransfer >= 31 && daysUntilTransfer <= 40) {
            valueFee = amount.multiply(BigDecimal.valueOf(0.047));

        } else if (daysUntilTransfer >= 41 && daysUntilTransfer <= 50) {
            valueFee = amount.multiply(BigDecimal.valueOf(0.017));

        } else {
            valueFee = BigDecimal.valueOf(-1);
        }

        return valueFee.setScale(2, RoundingMode.HALF_UP);
    }
}
