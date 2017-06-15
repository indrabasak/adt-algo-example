package com.basaki.pattern.mediator;

public class Runway
        implements ICommand {
    private IMediator mediator;

    public Runway(IMediator mediator) {
        this.mediator = mediator;
        mediator.setLandingStatus(true);
    }

    @Override
    public void land() {
        System.out.println("Landing permission granted...");
        mediator.setLandingStatus(true);
    }
}
