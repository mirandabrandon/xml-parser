package com.xml.parser.xml_parser.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "bsid")
public class Bsid {

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
    private String kunnr;    // Nº cliente
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
    private String sgtxt;    // Texto do item
    private String zterm;    // Chave de condições de pagamento
    private LocalDate undefinedDateField; // TODO: solve field
    private String zlsch;    // Forma de pagamento
    private String zlspr;    // Chave para o bloqueio de pagamento
    private String zbfix;    // Condição de pagamento fixada
    private String hbkid;    // Chave breve de um banco da empresa
    private String anfben;   // Nº documento da solicitação de letra de câmbio
    private String xnetb;    // Código: documento registrado com valor líquido ?
    private String mwsk1;    // Código IVA para repartição
    private Double dmbt1;    // Montante em moeda interna para divisão dos impostos
    private Double wrbt1;    // Montante em moeda estrangeira da repartição dos impostos
    private Double dmbt2;    // Montante em moeda interna para divisão dos impostos
    private Double dmbt3;    // Montante em moeda interna para divisão dos impostos
    private Double wrbt3;    // Montante em moeda estrangeira da repartição dos impostos
    private String vbund;    // Nº sociedade parceira
    private String vbeln;    // Documento de faturamento
    private Double dmb21;    // Montante na moeda interna-2 para repartição do imposto
    private Double dmb22;    // Montante na moeda interna-2 para repartição do imposto
    private Double dmb23;    // Montante na moeda interna-2 para repartição do imposto
    private Double dmb31;    // Montante na moeda interna-3 para repartição do imposto
    private Double dmb32;    // Montante na moeda interna-3 para repartição do imposto
    private Double dmb33;    // Montante na moeda interna-3 para repartição do imposto
    private Double mwst2;    // Montante IVA na moeda interna-2
    private Double mwst3;    // Montante do imposto na moeda interna-3
    private Double sknt2;    // Montante do desconto na moeda interna-2
    private Double sknt3;    // Montante do desconto na moeda interna-3
    private LocalDate dabrz; // Data de referência para liquidação
    private String empfb;    // Recebedor de pagamento/pagador
    private String xpypr;    // Código: partida bloqueada pelo programa de pagamento
    private String kidno;    // Referência de pagamento
    private String bupla;    // Local de negócios
    private String paysProv; // Fornecedor de serviços de pagamento
    private String paysTran; // Referência do pagamento do fornecedor serviços de pagamento
    private String mndid;    // Referência única no mandato por recebedor do pagamento
    // TODO: fix fields below
    private Double undefinedCurrencyField1;  // Campo no formato moeda não identificado
    private Double undefinedCurrencyField2;  // Campo no formato moeda não identificado
    private Double undefinedCurrencyField3;  // Campo no formato moeda não identificado
    private Double undefinedCurrencyField4;  // Campo no formato moeda não identificado
    private String extrafield; // TODO: the linha content ends with a ; so the parse sees as a field... don't know what to do yet

}
