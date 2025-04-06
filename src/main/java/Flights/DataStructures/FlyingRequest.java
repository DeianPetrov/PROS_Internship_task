package Flights.DataStructures;

public class FlyingRequest {
    private String origin;
    private String destination;
    private Integer maxFlights;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getMaxFlights() {
        return maxFlights;
    }

    public void setMaxFlights(Integer maxFlights) {
        this.maxFlights = maxFlights;
    }
}