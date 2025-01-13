package com.xml.parser.xml_parser.model;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseLine {

    private String rawLinha;
    private String xmlFileName;
    private LocalDateTime parseDate;

    public Object parse() {
        return null;
    }

    public String[] getFieldsArray() {
        try {
            // configure the CSVReader with semicolon as the delimiter
            CSVReader reader = new CSVReaderBuilder(new StringReader(this.rawLinha)).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();

            // return the parsed fields
            return reader.readNext();
        } catch (Exception e) {
            throw new RuntimeException("Error parsing rawLinha: " + this.rawLinha, e);
        }
    }

    protected LocalDate parseDate(String date, DateTimeFormatter formatter) {
        if (date == null || date.isEmpty() || date.equals("00000000")) {
            return null;
        }
        return LocalDate.parse(date, formatter);
    }

    protected Double parseDouble(String value) {
        return value.isEmpty() ? null : Double.parseDouble(value);
    }

    protected Long parseLong(String value) {
        return value.isEmpty() ? null : Long.parseLong(value);
    }
}
