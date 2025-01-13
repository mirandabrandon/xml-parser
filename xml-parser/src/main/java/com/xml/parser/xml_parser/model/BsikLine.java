package com.xml.parser.xml_parser.model;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@AllArgsConstructor
public class BsikLine extends BaseLine {

    @Override
    public Bsik parse() {
        try {
            String[] fields = getFieldsArray();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            int index = 0;
            
            Bsik bsik = new Bsik();

            bsik.setBukrs(fields[index ++]);
            bsik.setLifnr(fields[index ++]);
            bsik.setAugdt(parseDate(fields[index ++], formatter));
            bsik.setAugbl(fields[index ++]);
            bsik.setZuonr(fields[index ++]);
            bsik.setBelnr(fields[index ++]);
            bsik.setBuzei(parseLong(fields[index ++]));
            bsik.setHBudat(parseDate(fields[index ++], formatter));
            bsik.setHBldat(parseDate(fields[index ++], formatter));
            bsik.setCpudt(parseDate(fields[index ++], formatter));
            bsik.setHWaers(fields[index ++]);
            bsik.setXblnr(fields[index ++]);
            bsik.setHBlart(fields[index ++]);
            bsik.setShkzg(fields[index ++]);
            bsik.setDmbtr(parseDouble(fields[index ++]));
            bsik.setWrbtr(parseDouble(fields[index ++]));
            bsik.setMwsts(parseDouble(fields[index ++]));
            bsik.setWmwst(parseDouble(fields[index ++]));
            bsik.setSgtxt(fields[index ++]);
            bsik.setZfbdt(parseDate(fields[index ++], formatter));
            bsik.setZterm(fields[index ++]);
            bsik.setUndefinedDateField(parseDate(fields[index ++], formatter));
            bsik.setZlsch(fields[index ++]);
            bsik.setZlspr(fields[index ++]);
            bsik.setZbfix(fields[index ++]);
            bsik.setHbkid(fields[index ++]);
            bsik.setLandl(fields[index ++]);
            bsik.setDmbt1(parseDouble(fields[index ++]));
            bsik.setDmbt2(parseDouble(fields[index ++]));
            bsik.setWrbt2(parseDouble(fields[index ++]));
            bsik.setQsskz(fields[index ++]);
            bsik.setQsshb(parseDouble(fields[index ++]));
            bsik.setQbshb(parseDouble(fields[index ++]));
            bsik.setQsfbt(parseDouble(fields[index ++]));
            bsik.setDmb21(parseDouble(fields[index ++]));
            bsik.setDmb22(parseDouble(fields[index ++]));
            bsik.setDmb23(parseDouble(fields[index ++]));
            bsik.setDmb31(parseDouble(fields[index ++]));
            bsik.setDmb32(parseDouble(fields[index ++]));
            bsik.setDmb33(parseDouble(fields[index ++]));
            bsik.setUzawe(fields[index ++]);
            bsik.setDabrz(parseDate(fields[index ++], formatter));
            bsik.setXnegp(fields[index ++]);
            bsik.setXpypr(fields[index ++]);
            bsik.setKidno(fields[index ++]);
            bsik.setPyamt(parseDouble(fields[index ++]));
            bsik.setPenrc(fields[index ++]);
            bsik.setGmvkz(fields[index ++]);
            bsik.setUndefinedFieldWith4Chars(fields[index ++]);
            bsik.setUndefinedCurrencyField1(parseDouble(fields[index ++]));
            bsik.setUndefinedCurrencyField2(parseDouble(fields[index ++]));
            bsik.setUndefinedCurrencyField3(parseDouble(fields[index ++]));
            bsik.setUndefinedCurrencyField4(parseDouble(fields[index ++]));
            bsik.setExtrafield(fields[index ++]);

            bsik.setRawLinha(super.getRawLinha());
            bsik.setXmlFileName(super.getXmlFileName());
            bsik.setParseDate(LocalDateTime.now());

            return bsik;

        } catch (Exception e) {
            throw new RuntimeException("Error parsing rawLinha: " + super.getRawLinha(), e);
        }
    }
}
