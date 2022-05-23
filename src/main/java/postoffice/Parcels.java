package postoffice;

public class Parcels extends PostalItems{

    public Parcels(int id, int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, String transport, int postid) {
        super(id, sender, departuredate, weight, price, arrivaldate, recipient, transport, postid);
    }

    public Parcels(int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, String transport, int postid) {
        super(sender, departuredate, weight, price, arrivaldate, recipient, transport, postid);
    }
}
