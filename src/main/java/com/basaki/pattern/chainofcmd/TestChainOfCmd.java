package com.basaki.pattern.chainofcmd;

public class TestChainOfCmd {


    public static final String NEGATIVE_VALUE = "Negative Value ";

    public static void main(String[] args) {
        // Setup Chain of Responsibility
        IHandler h1 = new ConcreteHandlerOne();
        IHandler h2 = new ConcreteHandlerTwo();
        IHandler h3 = new ConcreteHandlerThree();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        // Send requests to the chain
        h1.handleRequest(new Request(-1, NEGATIVE_VALUE));
        h1.handleRequest(new Request(0, NEGATIVE_VALUE));
        h1.handleRequest(new Request(1, NEGATIVE_VALUE));
        h1.handleRequest(new Request(2, NEGATIVE_VALUE));
        h1.handleRequest(new Request(3, NEGATIVE_VALUE));

    }

}
