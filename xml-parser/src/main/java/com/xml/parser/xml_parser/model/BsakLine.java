package com.xml.parser.xml_parser.model;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class BsakLine extends BaseLine {

    @Override
    public Bsak parse() {
        try {
            String[] fields = getFieldsArray();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            int index = 0;

            Bsak bsak = new Bsak();

            bsak.setBukrs(fields[index++]);
            bsak.setLifnr(fields[index++]);
            bsak.setAugdt(parseDate(fields[index++], formatter));
            bsak.setAugbl(fields[index++]);
            bsak.setZuonr(fields[index++]);
            bsak.setBelnr(fields[index++]);
            bsak.setBuzei(parseLong(fields[index++]));
            bsak.setBudat(parseDate(fields[index++], formatter));
            bsak.setBldat(parseDate(fields[index++], formatter));
            bsak.setCpudt(parseDate(fields[index++], formatter));
            bsak.setWaers(fields[index++]);
            bsak.setXblnr(fields[index++]);
            bsak.setBlart(fields[index++]);
            bsak.setBschl(fields[index++]);
            bsak.setShkzg(fields[index++]);
            bsak.setDmbtr(parseDouble(fields[index++]));
            bsak.setWrbtr(parseDouble(fields[index++]));
            bsak.setMwsts(parseDouble(fields[index++]));
            bsak.setWmwst(parseDouble(fields[index++]));
            bsak.setZfbdt(parseDate(fields[index++], formatter));
            bsak.setZterm(fields[index++]);
            bsak.setUndefinedDateField(parseDate(fields[index++], formatter));
            bsak.setZlsch(fields[index++]);
            bsak.setZlspr(fields[index++]);
            bsak.setZbfix(fields[index++]);
            bsak.setHbkid(fields[index++]);
            bsak.setLandl(fields[index++]);
            bsak.setDmbt1(parseDouble(fields[index++]));
            bsak.setDmbt2(parseDouble(fields[index++]));
            bsak.setWrbt2(parseDouble(fields[index++]));
            bsak.setQsskz(fields[index++]);
            bsak.setQsshb(parseDouble(fields[index++]));
            bsak.setQbshb(parseDouble(fields[index++]));
            bsak.setQsfbT(parseDouble(fields[index++]));
            bsak.setDmb21(parseDouble(fields[index++]));
            bsak.setDmb22(parseDouble(fields[index++]));
            bsak.setDmb23(parseDouble(fields[index++]));
            bsak.setDmb31(parseDouble(fields[index++]));
            bsak.setDmb32(parseDouble(fields[index++]));
            bsak.setDmb33(parseDouble(fields[index++]));
            bsak.setUzawe(fields[index++]);
            bsak.setDabrz(parseDate(fields[index++], formatter));
            bsak.setEmpfb(fields[index++]);
            bsak.setXpypr(fields[index++]);
            bsak.setKidno(fields[index++]);
            bsak.setPyamt(parseDouble(fields[index++]));
            bsak.setPenrc(fields[index++]);
            bsak.setExtrafield(fields[index++]);

            bsak.setRawLinha(super.getRawLinha());
            bsak.setXmlFileName(super.getXmlFileName());
            bsak.setParseDate(LocalDateTime.now());

            return null;

        } catch (Exception e) {
            throw new RuntimeException("Error parsing rawLinha: " + super.getRawLinha(), e);
        }
    }
}
