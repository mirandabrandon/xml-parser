package com.xml.parser.xml_parser.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "bsak")
public class Bsak {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "raw_linha", columnDefinition = "TEXT")
    private String rawLinha;

    @Column(name = "xml_file_name")
    private String xmlFileName;

    @Column(name = "parse_date")
    private LocalDateTime parseDate;

    private String bukrs;    // Empresa
    private String lifnr;    // Nº conta do fornecedor
    private LocalDate augdt; // Data de compensação
    private String augbl;    // Nº documento de compensação
    private String zuonr;    // Nº atribuição
    private String belnr;    // Nº documento de um documento contábil
    private Long buzei;      // Nº linha de lançamento no documento contábil
    private LocalDate budat; // Data de lançamento no documento
    private LocalDate bldat; // Data no documento
    private LocalDate cpudt; // Data da entrada do documento contábil
    private String waers;    // Código da moeda
    private String xblnr;    // Nº documento de referência
    private String blart;    // Tipo de documento
    private String bschl;    // Chave de lançamento
    private String shkzg;    // Código débito/crédito
    private Double dmbtr;    // Montante em moeda interna
    private Double wrbtr;    // Montante em moeda do documento
    private Double mwsts;    // Montante de imposto em MI
    private Double wmwst;    // Montante de imposto na moeda do documento
    private LocalDate zfbdt; // Data base para cálculo do vencimento
    private String zterm;    // Chave de condições de pagamento
    private LocalDate undefinedDateField; // TODO: solve field
    private String zlsch;    // Forma de pagamento
    private String zlspr;    // Chave para o bloqueio de pagamento
    private String zbfix;    // Condição de pagamento fixada
    private String hbkid;    // Chave breve de um banco da empresa
    private String landl;    // País do fornecedor
    private Double dmbt1;    // Montante em moeda interna para divisão dos impostos
    private Double dmbt2;    // Montante em moeda interna para divisão dos impostos
    private Double wrbt2;    // Montante em moeda estrangeira da repartição dos impostos
    private String qsskz;    // Código de imposto retido na fonte
    private Double qsshb;    // Montante base do imposto retido na fonte
    private Double qbshb;    // Montante de imposto retido na fonte (em moeda de documento)
    private Double qsfbT;    // Montante isento de imposto retido na fonte (em moeda doc.)
    private Double dmb21;    // Montante na moeda interna-2 para repartição do imposto
    private Double dmb22;    // Montante na moeda interna-2 para repartição do imposto
    private Double dmb23;    // Montante na moeda interna-2 para repartição do imposto
    private Double dmb31;    // Montante na moeda interna-3 para repartição do imposto
    private Double dmb32;    // Montante na moeda interna-3 para repartição do imposto
    private Double dmb33;    // Montante na moeda interna-3 para repartição do imposto
    private String uzawe;    // Suplemento à forma de pagamento
    private LocalDate dabrz; // Data de referência para liquidação
    private String empfb;    // Recebedor de pagamento/pagador
    private String xpypr;    // Código: partida bloqueada pelo programa de pagamento
    private String kidno;    // Referência de pagamento
    private Double pyamt;    // Montante em moeda de pagamento
    private String penrc;    // Motivo para o pagamento atrasado
    private String extrafield; // TODO: the linha content ends with a ; so the parse sees as a field... don't know what to do yet

}
