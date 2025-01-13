package com.xml.parser.xml_parser.service;

import com.xml.parser.xml_parser.model.*;
import com.xml.parser.xml_parser.repository.BsadRepository;
import com.xml.parser.xml_parser.repository.BsakRepository;
import com.xml.parser.xml_parser.repository.BsidRepository;
import com.xml.parser.xml_parser.repository.BsikRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.xml.parser.xml_parser.util.CollectionUtils.castList;
import static com.xml.parser.xml_parser.util.CollectionUtils.saveBatch;

@Service
public class XmlParser {

    private static final Logger logger = LoggerFactory.getLogger(XmlParser.class);

    @Autowired
    private BsikRepository bsikRepository;
    @Autowired
    private BsidRepository bsidRepository;
    @Autowired
    private BsadRepository bsadRepository;
    @Autowired
    private BsakRepository bsakRepository;

    @Value("${xml.parser.batch-size:100}") // Use 100 as default if the variable isn't set
    private int batchSize;

    // map for each line parser class based in file name
    private final Map<String, Class<? extends BaseLine>> fileToParserMap = Map.of(
            "bsik", BsikLine.class,
            "bsid", BsidLine.class,
            "bsad", BsadLine.class,
            "bsak", BsakLine.class);

    /**
     * Parser main flow, where basically get the files using given folder path, identify the file being handled, group them in a map and save
     *
     * @param folderPath Path to folder containing the xml files to be parsed
     */
    public void parseXmlFileToObjectsAndSaveInDb(String folderPath) {
        File[] files = getXmlFilesInFolder(folderPath);

        if (files == null) return;

        for (File file : files) {
            try {
                logger.info("Processing file: {}", file.getName());

                final ParsedXmlFile parsedXmlFile = parseXmlFile(file);
                final String filePrefix = getFilePrefix(parsedXmlFile.getHeader().getFileName());
                final Class<? extends BaseLine> correspondingLineClass = fileToParserMap.get(filePrefix);

                if (correspondingLineClass == null) {
                    logger.warn("Unknown file type: {}", filePrefix);
                    return;
                }

                long start = System.nanoTime();

                // parsing and grouping lines in a Map to save them in batches to optimize performance
                Map<Class<?>, List<Object>> groupedLines = parseAndGroupTheLines(parsedXmlFile, correspondingLineClass);

                // saving the mapped classes in batches to a better performance
                saveParsedLinesInBatches(groupedLines);

                long end = System.nanoTime();
                long duration = (end - start) / 1_000_000;
                System.out.println("Processing time: " + duration + " ms");

            } catch (Exception e) {
                System.out.println("An error occurred while processing the file '" + file.getName() + "'. Cause: " + e.getMessage());
            }
        }

    }

    /**
     * Parse the lines to the corresponding Line Java object (for exmaple: LinhaBsik)
     *
     * @param parsedXmlFile The Java object that represents the entire XML file structure
     * @param parserClass   The specialized line class that extends from LinhaBase, computed based in file name
     * @return The lines of this file grouped in a Map, where the key is the specialized line class and the list of corresponding lines
     * @throws Exception If the parse or group gets an error
     */
    private Map<Class<?>, List<Object>> parseAndGroupTheLines(ParsedXmlFile parsedXmlFile, Class<? extends BaseLine> parserClass) throws Exception {
        Map<Class<?>, List<Object>> groupedLines = new HashMap<>();

        for (Dados dados : parsedXmlFile.getDadosList()) {
            BaseLine linha = parserClass.getDeclaredConstructor().newInstance();
            linha.setRawLinha(dados.getLinha());
            linha.setXmlFileName(parsedXmlFile.getHeader().getFileName());
            linha.setParseDate(LocalDateTime.now());

            Object parsedLinha = linha.parse();

            // checks if the specified key exists in the map.
            // if exists, retrieves the existing list associated to that key.
            // if doesn't exist, computes a new value using the lambda and creates a new list
            groupedLines.computeIfAbsent(parsedLinha.getClass(), k -> new ArrayList<>()).add(parsedLinha);
        }

        return groupedLines;
    }

    /**
     * Iterate over the lines map, cast the list of records to the corresponding business object class and calls a method to save multiple records in batches
     *
     * @param groupedLines The map of class and list of objects.
     */
    private void saveParsedLinesInBatches(Map<Class<?>, List<Object>> groupedLines) {

        // iterate over the map of lines, cast the list of records to the corresponding business object class and calls a method to save multiple records in batches

        groupedLines.forEach((lineClass, parsedLines) -> {
            if (lineClass.equals(Bsik.class)) {
                saveBatch(castList(parsedLines, Bsik.class), bsikRepository, batchSize);
            } else if (lineClass.equals(Bsid.class)) {
                saveBatch(castList(parsedLines, Bsid.class), bsidRepository, batchSize);
            } else if (lineClass.equals(Bsad.class)) {
                saveBatch(castList(parsedLines, Bsad.class), bsadRepository, batchSize);
            } else if (lineClass.equals(Bsak.class)) {
                saveBatch(castList(parsedLines, Bsak.class), bsakRepository, batchSize);
            } else {
                logger.warn("Unknown class for persistence: {}", lineClass.getName());
            }
        });
    }

    private String getFilePrefix(final String fullFileName) {
        return fullFileName.split("_")[0].toLowerCase();
    }

    /**
     * Get the files in given folder path
     *
     * @param folderPath A string containing the path to the folder
     * @return The list of files found in folder path using a filter based in file name
     */

    public static File[] getXmlFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Path is not a directory: " + folderPath);
        }

        // list all xml files that name starts with "bs" in the folder
        // TODO: maybe a more specific filter based in name will be needed
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().startsWith("bsik") && name.toLowerCase().endsWith(".xml"));

        if (files == null || files.length == 0) {
            logger.warn("No XML files found in folder: {}", folderPath);
            return null;
        }
        return files;
    }

    /**
     * Create the unmarshaller and parse the XML file to a Java object, respecting and replicating the tag hierarchy
     *
     * @param file The file found in folder given
     * @return The parsed file into a Java object: ParsedXmlFile
     * @throws JAXBException If the file can't be parsed to parsedXmlFile
     */
    private static ParsedXmlFile parseXmlFile(File file) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(ParsedXmlFile.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (ParsedXmlFile) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            logger.error("Error parsing file '{}'", file.getName(), e);
            throw e;
        }
    }
}
