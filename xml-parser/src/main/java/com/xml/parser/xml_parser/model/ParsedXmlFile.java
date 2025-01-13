package com.xml.parser.xml_parser.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "MT_Out_Proxy_File_portal", namespace = "http://toyota.com.br/FICO/portal")
@XmlType(propOrder = {"header", "dadosList"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsedXmlFile {

    @XmlElement(name = "header")
    private Header header;

    @XmlElement(name = "dados")
    private List<Dados> dadosList;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<Dados> getDadosList() {
        return dadosList;
    }

    public void setDadosList(List<Dados> dadosList) {
        this.dadosList = dadosList;
    }
}

