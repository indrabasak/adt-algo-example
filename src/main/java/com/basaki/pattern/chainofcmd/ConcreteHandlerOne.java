package com.basaki.pattern.chainofcmd;

public class ConcreteHandlerOne
        implements IHandler {
    private IHandler successor;

    public void setSuccessor(IHandler successor) {
        this.successor = successor;
    }

    public void handleRequest(Request request) {
        if (request.getValue() < 0) {
            // if request is eligible handle it
            System.out
                    .println("Negative values are handled by ConcreteHandlerOne:");
            System.out.println("\tConcreteHandlerOne.HandleRequest : "
                    + request.getDescription() + request.getValue());
        } else {
            //super.handleRequest(request);
            successor.handleRequest(request);
        }
    }
}
