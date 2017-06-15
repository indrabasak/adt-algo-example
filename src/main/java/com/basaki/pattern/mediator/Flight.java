package com.basaki.pattern.mediator;

public class Flight
        implements ICommand {

    private IMediator mediator;

    public Flight(IMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void land() {
        if (mediator.isLandingOk()) {
            System.out.println("Landing done....");
            mediator.setLandingStatus(true);
        } else {
            System.out.println("Will wait to land....");
        }
    }

    public void getReady() {
        System.out.println("Getting ready...");
    }
}
