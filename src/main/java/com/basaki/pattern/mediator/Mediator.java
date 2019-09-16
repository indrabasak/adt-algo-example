package com.basaki.pattern.mediator;

@SuppressWarnings({"squid:S1450", "squid:S1068"})
public class Mediator implements IMediator {
    private boolean land;

    private Flight flight;

    private Runway runway;

    public void registerRunway(Runway runway) {
        this.runway = runway;
    }

    public void registerFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isLandingOk() {
        return land;
    }

    @Override
    public void setLandingStatus(boolean status) {
        land = status;
    }
}
