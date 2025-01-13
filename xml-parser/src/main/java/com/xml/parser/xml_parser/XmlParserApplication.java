package com.xml.parser.xml_parser;


import com.xml.parser.xml_parser.service.XmlParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "com.xml.parser.xml_parser")
public class XmlParserApplication {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        // start the Spring application and retrieve the application context
        ApplicationContext context = SpringApplication.run(XmlParserApplication.class, args);

        // get the XmlParser bean
        XmlParser xmlParser = context.getBean(XmlParser.class);

        // Prompt for user confirmation
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Loop for repeated execution
        do {
            System.out.println("Do you want to execute the parse flow? Type 'Y' to proceed or 'N' to exit:");
            userInput = scanner.nextLine().trim();

            if ("Y".equalsIgnoreCase(userInput)) {
                String folderPath = "/home/brandon/Documentos/Toyota/Archive"; // Update with the actual path
                xmlParser.parseXmlFileToObjectsAndSaveInDb(folderPath);
                System.out.println("Parse flow completed.");
            } else if (!"N".equalsIgnoreCase(userInput)) {
                System.out.println("Invalid input. Please type 'Y' or 'N'.");
            }
        } while (!"N".equalsIgnoreCase(userInput));

        System.out.println("Exiting the application.");
    }
}
