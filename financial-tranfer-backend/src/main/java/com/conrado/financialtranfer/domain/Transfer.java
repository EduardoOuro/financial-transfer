package com.conrado.financialtranfer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transfer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "conta_origem")
    private String contaOrigem ;

    @Column(name = "conta_destino")
    private String contaDestino;

    @Column(name = "valor")
    private BigDecimal valor;


    @Column(name = "taxa")
    private BigDecimal taxa;

    @Column(name = "data_transferencia")
    private LocalDate dataTransferencia;

    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;

    public String getContaOrigem() {
        return contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public BigDecimal getValorTransferencia() {
        return valor;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public LocalDate getDataTransferencia() {
        return dataTransferencia;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }
}
