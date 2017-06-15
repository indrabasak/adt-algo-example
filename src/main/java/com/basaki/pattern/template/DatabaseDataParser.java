package com.basaki.pattern.template;

public class DatabaseDataParser extends ADataParser {

    @Override
    void readData() {
        System.out.println("Reading data from database");

    }

    @Override
    void processData() {
        System.out.println("Looping through datasets");
    }
}
