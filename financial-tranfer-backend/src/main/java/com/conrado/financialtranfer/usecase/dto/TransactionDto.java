package com.conrado.financialtranfer.usecase.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDto {
    private String sourceAccount;
    private String destinationAccount;
    private BigDecimal amount;
    private LocalDate transferDate;

    public TransactionDto(String sourceAccount, String destinationAccount, BigDecimal amount, LocalDate transferDate) {
        this.sourceAccount = sourceAccount != null ? sourceAccount : "ABCD";
        this.destinationAccount = destinationAccount != null ? destinationAccount : "ABCD";
        this.amount = amount != null ? amount : BigDecimal.valueOf(1000.00);
        this.transferDate = transferDate != null ? transferDate : LocalDate.now();
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }


    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "sourceAccount='" + sourceAccount + '\'' +
                ", destinationAccount='" + destinationAccount + '\'' +
                ", amount=" + amount +
                ", transferDate=" + transferDate +
                '}';
    }
}
