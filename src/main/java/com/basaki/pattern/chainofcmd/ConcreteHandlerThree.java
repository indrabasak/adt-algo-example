package com.basaki.pattern.chainofcmd;

public class ConcreteHandlerThree
        implements IHandler {
    private IHandler successor;

    public void setSuccessor(IHandler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getValue() >= 0) { // if request is eligible handle it
            System.out
                    .println("Zero values are handled by ConcreteHandlerThree:");
            System.out.println("\tConcreteHandlerThree.HandleRequest : "
                    + request.getDescription() + request.getValue());
        } else {
            successor.handleRequest(request);
        }
    }
}
