package Flights.DataStructures;
import java.util.ArrayList;
import java.util.List;

public class FlyingPath implements Comparable<FlyingPath>{
    private List<String>flyingPath;
    private int totalPrice;

    public FlyingPath() {
        flyingPath = new ArrayList<>();
        totalPrice = 0;
    }
    public FlyingPath(List<String>flyingPath, int totalPrice) {
        this.flyingPath = flyingPath;
        this.totalPrice = totalPrice;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public List<String> getFlyingPath() {
        return flyingPath;
    }
    public void setFlyingPath(List<String> flyingPath) {
        this.flyingPath = flyingPath;
    }
    @Override
    public int compareTo(FlyingPath other) {
        return Integer.compare(this.totalPrice, other.totalPrice);
    }

}
