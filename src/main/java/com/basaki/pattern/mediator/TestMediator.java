package com.basaki.pattern.mediator;

public class TestMediator {

    public static void main(String[] args) {
        IMediator atcMediator = new Mediator();
        Flight sparrow101 = new Flight(atcMediator);
        Runway mainRunway = new Runway(atcMediator);
        atcMediator.registerFlight(sparrow101);
        atcMediator.registerRunway(mainRunway);
        sparrow101.getReady();
        mainRunway.land();
        sparrow101.land();

    }

}
