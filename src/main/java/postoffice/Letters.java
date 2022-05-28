package postoffice;

public class Letters extends PostalItems {

    public Letters(int id, int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, int transportid, int postid) {
        super(id, sender, departuredate, weight, price, arrivaldate, recipient, transportid, postid);
    }

    public Letters(int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, int transportid, int postid) {
        super(sender, departuredate, weight, price, arrivaldate, recipient, transportid, postid);
    }
}

