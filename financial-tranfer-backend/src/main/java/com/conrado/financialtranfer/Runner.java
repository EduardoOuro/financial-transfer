package com.conrado.financialtranfer;

import com.conrado.financialtranfer.usecase.FindAllTransaction;
import com.conrado.financialtranfer.usecase.dto.TransactionDto;
import com.conrado.financialtranfer.usecase.dto.TransactionResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Service
public class Runner implements CommandLineRunner {
    public FindAllTransaction findAllTransaction;

    @Autowired
    public Runner(FindAllTransaction findAllTransaction) {
        this.findAllTransaction = findAllTransaction;
    }

    @Override
    public void run(String... args) throws Exception {
        List<TransactionResultDto> result = findAllTransaction.execute(1L);
        System.out.println("Resultado da transação: " + result.toString());
    }
}
