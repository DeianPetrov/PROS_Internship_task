package Flights.DataStructures;

public class SingleFlypoint {

    private String From;
    private String To;
    private int Price;

    public SingleFlypoint(String from, String to, int price) {
        From = from;
        To = to;
        Price = price;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public int getPrice() {
        return Price;
    }

    public void setFrom(String from) {
            From = from;
    }
    public void setTo(String to) {
            To = to;

    }

    public void setPrice(int price) {
        if (price>0){
            Price = price;
        }
    }

}
