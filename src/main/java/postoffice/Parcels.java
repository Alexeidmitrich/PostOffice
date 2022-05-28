package postoffice;

public class Parcels extends PostalItems{

    public Parcels(int id, int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, int transportid, int postid) {
        super(id, sender, departuredate, weight, price, arrivaldate, recipient, transportid, postid);
    }

    public Parcels(int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, int transportid, int postid) {
        super(sender, departuredate, weight, price, arrivaldate, recipient, transportid, postid);
    }
}
