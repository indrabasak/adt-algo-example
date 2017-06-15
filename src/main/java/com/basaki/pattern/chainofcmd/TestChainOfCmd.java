package com.basaki.pattern.chainofcmd;

public class TestChainOfCmd {

    public TestChainOfCmd() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // Setup Chain of Responsibility
        IHandler h1 = new ConcreteHandlerOne();
        IHandler h2 = new ConcreteHandlerTwo();
        IHandler h3 = new ConcreteHandlerThree();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        // Send requests to the chain
        h1.handleRequest(new Request(-1, "Negative Value "));
        h1.handleRequest(new Request(0, "Negative Value "));
        h1.handleRequest(new Request(1, "Negative Value "));
        h1.handleRequest(new Request(2, "Negative Value "));
        h1.handleRequest(new Request(3, "Negative Value "));

    }

}
