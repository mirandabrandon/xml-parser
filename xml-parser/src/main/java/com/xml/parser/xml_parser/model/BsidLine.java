package com.xml.parser.xml_parser.model;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class BsidLine extends BaseLine {

    @Override
    public Bsid parse() {
        try {
            String[] fields = getFieldsArray();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            int index = 0;

            Bsid bsid = new Bsid();

            bsid.setBukrs(fields[index++]);
            bsid.setKunnr(fields[index++]);
            bsid.setAugdt(parseDate(fields[index++], formatter));
            bsid.setAugbl(fields[index++]);
            bsid.setZuonr(fields[index++]);
            bsid.setBelnr(fields[index++]);
            bsid.setBuzei(parseLong(fields[index++]));
            bsid.setBudat(parseDate(fields[index++], formatter));
            bsid.setBldat(parseDate(fields[index++], formatter));
            bsid.setCpudt(parseDate(fields[index++], formatter));
            bsid.setWaers(fields[index++]);
            bsid.setXblnr(fields[index++]);
            bsid.setBlart(fields[index++]);
            bsid.setBschl(fields[index++]);
            bsid.setShkzg(fields[index++]);
            bsid.setDmbtr(parseDouble(fields[index++]));
            bsid.setWrbtr(parseDouble(fields[index++]));
            bsid.setMwsts(parseDouble(fields[index++]));
            bsid.setWmwst(parseDouble(fields[index++]));
            bsid.setSgtxt(fields[index++]);
            bsid.setZterm(fields[index++]);
            bsid.setUndefinedDateField(parseDate(fields[index++], formatter));
            bsid.setZlsch(fields[index++]);
            bsid.setZlspr(fields[index++]);
            bsid.setZbfix(fields[index++]);
            bsid.setHbkid(fields[index++]);
            bsid.setAnfben(fields[index++]);
            bsid.setXnetb(fields[index++]);
            bsid.setMwsk1(fields[index++]);
            bsid.setDmbt1(parseDouble(fields[index++]));
            bsid.setWrbt1(parseDouble(fields[index++]));
            bsid.setDmbt2(parseDouble(fields[index++]));
            bsid.setDmbt3(parseDouble(fields[index++]));
            bsid.setWrbt3(parseDouble(fields[index++]));
            bsid.setVbund(fields[index++]);
            bsid.setVbeln(fields[index++]);
            bsid.setDmb21(parseDouble(fields[index++]));
            bsid.setDmb22(parseDouble(fields[index++]));
            bsid.setDmb23(parseDouble(fields[index++]));
            bsid.setDmb31(parseDouble(fields[index++]));
            bsid.setDmb32(parseDouble(fields[index++]));
            bsid.setDmb33(parseDouble(fields[index++]));
            bsid.setMwst2(parseDouble(fields[index++]));
            bsid.setMwst3(parseDouble(fields[index++]));
            bsid.setSknt2(parseDouble(fields[index++]));
            bsid.setSknt3(parseDouble(fields[index++]));
            bsid.setDabrz(parseDate(fields[index++], formatter));
            bsid.setEmpfb(fields[index++]);
            bsid.setXpypr(fields[index++]);
            bsid.setKidno(fields[index++]);
            bsid.setBupla(fields[index++]);
            bsid.setPaysProv(fields[index++]);
            bsid.setPaysTran(fields[index++]);
            bsid.setMndid(fields[index++]);
            bsid.setUndefinedCurrencyField1(parseDouble(fields[index++]));
            bsid.setUndefinedCurrencyField2(parseDouble(fields[index++]));
            bsid.setUndefinedCurrencyField3(parseDouble(fields[index++]));
            bsid.setUndefinedCurrencyField4(parseDouble(fields[index++]));
            bsid.setExtrafield(fields[index++]);

            bsid.setRawLinha(super.getRawLinha());
            bsid.setXmlFileName(super.getXmlFileName());
            bsid.setParseDate(LocalDateTime.now());

            return bsid;

        } catch (Exception e) {
            throw new RuntimeException("Error parsing rawLinha: " + super.getRawLinha(), e);
        }
    }
}
