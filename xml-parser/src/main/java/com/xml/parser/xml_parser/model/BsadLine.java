package com.xml.parser.xml_parser.model;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class BsadLine extends BaseLine {
    
    @Override
    public Bsad parse() {
        try {
            String[] fields = getFieldsArray();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            int index = 0;
            
            Bsad bsad = new Bsad();

            bsad.setBukrs(fields[index++]);
            bsad.setKunnr(fields[index++]);
            bsad.setAugdt(parseDate(fields[index++], formatter));
            bsad.setAugbl(fields[index++]);
            bsad.setZuonr(fields[index++]);
            bsad.setBelnr(fields[index++]);
            bsad.setBuzei(parseLong(fields[index++]));
            bsad.setBudat(parseDate(fields[index++], formatter));
            bsad.setBldat(parseDate(fields[index++], formatter));
            bsad.setCpudt(parseDate(fields[index++], formatter));
            bsad.setWaers(fields[index++]);
            bsad.setXblnr(fields[index++]);
            bsad.setBlart(fields[index++]);
            bsad.setBschl(fields[index++]);
            bsad.setDmbtr(parseDouble(fields[index++]));
            bsad.setWrbtr(parseDouble(fields[index++]));
            bsad.setMwsts(parseDouble(fields[index++]));
            bsad.setWmwst(parseDouble(fields[index++]));
            bsad.setSgtxt(fields[index++]);
            bsad.setZterm(fields[index++]);
            bsad.setZlsch(fields[index++]);
            bsad.setUndefinedDateField(parseDate(fields[index++], formatter));
            bsad.setZlSpr(fields[index++]);
            bsad.setXnetb(fields[index++]);
            bsad.setMwsk1(fields[index++]);
            bsad.setDmbt1(parseDouble(fields[index++]));
            bsad.setWrbt1(parseDouble(fields[index++]));
            bsad.setDmbt2(parseDouble(fields[index++]));
            bsad.setDmbt3(parseDouble(fields[index++]));
            bsad.setWrbt3(parseDouble(fields[index++]));
            bsad.setVbund(fields[index++]);
            bsad.setDmb21(parseDouble(fields[index++]));
            bsad.setDmb22(parseDouble(fields[index++]));
            bsad.setDmb23(parseDouble(fields[index++]));
            bsad.setDmb31(parseDouble(fields[index++]));
            bsad.setDmb32(parseDouble(fields[index++]));
            bsad.setDmb33(parseDouble(fields[index++]));
            bsad.setMwst2(parseDouble(fields[index++]));
            bsad.setMwst3(parseDouble(fields[index++]));
            bsad.setSknt2(parseDouble(fields[index++]));
            bsad.setSknt3(parseDouble(fields[index++]));
            bsad.setDabrz(parseDate(fields[index++], formatter));
            bsad.setXnegp(fields[index++]);
            bsad.setEmpfb(fields[index++]);
            bsad.setXpypr(fields[index++]);
            bsad.setKidno(fields[index++]);
            bsad.setPaysProv(fields[index++]);
            bsad.setExtrafield(fields[index++]);

            bsad.setRawLinha(super.getRawLinha());
            bsad.setXmlFileName(super.getXmlFileName());
            bsad.setParseDate(LocalDateTime.now());

            return null;

        } catch (Exception e) {
            throw new RuntimeException("Error parsing rawLinha: " + super.getRawLinha(), e);
        }
    }

}
