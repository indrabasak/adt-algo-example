package com.basaki.pattern.template;

public class CSVDataParser extends ADataParser {

    @Override
    void readData() {
        System.out.println("Reading data from csv file");
    }

    @Override
    void processData() {
        System.out.println("Looping through loaded csv file");
    }
}
