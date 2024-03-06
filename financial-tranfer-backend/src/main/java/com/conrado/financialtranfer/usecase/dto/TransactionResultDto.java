package com.conrado.financialtranfer.usecase.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionResultDto {
    private String sourceAccount;
    private String destinationAccount;
    private BigDecimal amount;
    private BigDecimal tax;
    private LocalDate transferDate;
    private LocalDate schedulingDate;

    public TransactionResultDto(String sourceAccount, String destinationAccount, BigDecimal amount, BigDecimal tax, LocalDate transferDate, LocalDate schedulingDate) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.tax = tax;
        this.transferDate = transferDate;
        this.schedulingDate = schedulingDate;
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

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public LocalDate getSchedulingDate() {
        return schedulingDate;
    }

    public void setSchedulingDate(LocalDate schedulingDate) {
        this.schedulingDate = schedulingDate;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    @Override
    public String toString() {
        return "TransactionResultDto{" +
                "sourceAccount='" + sourceAccount + '\'' +
                ", destinationAccount='" + destinationAccount + '\'' +
                ", amount=" + amount +
                ", tax=" + tax +
                ", transferDate=" + transferDate +
                ", schedulingDate=" + schedulingDate +
                '}';
    }
}
