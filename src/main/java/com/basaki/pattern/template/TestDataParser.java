package com.basaki.pattern.template;

@SuppressWarnings({"squid:S106"})
public class TestDataParser {

    public static void main(String[] args) {
        CSVDataParser csvDataParser = new CSVDataParser();
        csvDataParser.parseDataAndGenerateOutput();
        System.out.println("**********************");
        DatabaseDataParser databaseDataParser = new DatabaseDataParser();
        databaseDataParser.parseDataAndGenerateOutput();
    }
}
