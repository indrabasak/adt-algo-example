package com.basaki.pattern.chainofcmd;

public class Request {

    private int value;

    private String description;

    public Request(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
