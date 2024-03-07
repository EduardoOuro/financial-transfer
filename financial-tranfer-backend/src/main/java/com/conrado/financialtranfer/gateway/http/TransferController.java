package com.conrado.financialtranfer.gateway.http;

import com.conrado.financialtranfer.usecase.FindAllTransaction;
import com.conrado.financialtranfer.usecase.NewTransaction;
import com.conrado.financialtranfer.usecase.dto.TransactionDto;
import com.conrado.financialtranfer.usecase.dto.TransactionResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/financial-transfer")
public class TransferController {

    @Autowired
    private NewTransaction newTransaction;
    @Autowired
    private FindAllTransaction findAllTransaction;



    @GetMapping
    public ResponseEntity<Iterable<TransactionResultDto>> listarTransferencias() {

        Iterable<TransactionResultDto> transfer =
                findAllTransaction.execute(1L);
        return new ResponseEntity<>(transfer, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TransactionResultDto> criarTransacao(
            @RequestParam String sourceAccount,
            @RequestParam String destinationAccount,
            @RequestParam BigDecimal amount,
            @RequestParam String transferDate
    ) {
        try{
            String[] parts = transferDate.split("-");

            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            LocalDate data = LocalDate.of(year, month, day);

            TransactionDto dto = new TransactionDto(
                    sourceAccount,
                    destinationAccount,
                    amount,
                    data
            );

            TransactionResultDto transfer =
                    newTransaction.execute(dto);
            return new ResponseEntity<>(transfer, HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
