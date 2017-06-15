package com.basaki.pattern.chainofcmd;

public class ConcreteHandlerTwo
        implements IHandler {
    private IHandler successor;

    public void setSuccessor(IHandler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getValue() > 0) { // if request is eligible handle it
            System.out
                    .println("Positive values are handled by ConcreteHandlerTwo:");
            System.out.println("\tConcreteHandlerTwo.HandleRequest : "
                    + request.getDescription() + request.getValue());
        } else {
            successor.handleRequest(request);
        }
    }
}
