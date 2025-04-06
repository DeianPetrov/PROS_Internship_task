package Flights.DataStructures;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PossiblePaths {

    private List<String> possiblePaths;
    private int price;

    public PossiblePaths(List<String> route, int price) {
        this.possiblePaths = route;
        this.price = price;
    }

    public List<String> getRoute() {
        return possiblePaths;
    }

    public void setRoute(List<String> route) {
        this.possiblePaths = route;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
