package com.basaki.pattern.template;

@SuppressWarnings({"squid:S1610", "squid:S106"})
public abstract class ADataParser {
    // Template method
    // This method defines a generic structure for parsing data
    public void parseDataAndGenerateOutput() {
        readData();
        processData();
        writeData();
    }

    // This methods will be implemented by its subclass
    abstract void readData();

    abstract void processData();

    // We have to write output in a CSV file so this step will be same for all
    // subclasses
    public void writeData() {
        System.out.println("Output generated,writing to CSV");
    }
}
