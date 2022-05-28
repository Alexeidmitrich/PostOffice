package postoffice;

public class PostalItems {
    protected int id;
    protected int sender;
    protected String departuredate;
    protected int weight;
    protected int price;
    protected String arrivaldate;
    protected  int recipient;
    protected int transportid;
    protected int postid;

    public PostalItems(int id,int sender,String departuredate,int weight,int price,String arrivaldate,int recipient,int transportid,int postid){
        this.id = id;
        this.sender = sender;
        this.departuredate = departuredate;
        this.weight = weight;
        this.price = price;
        this.arrivaldate = arrivaldate;
        this.recipient = recipient;
        this.transportid = transportid;
        this.postid = postid;
    }
    public PostalItems(int sender,String departuredate,int weight,int price,String arrivaldate,int recipient, int transportid,int postid){
        this.sender = sender;
        this.departuredate = departuredate;
        this.weight = weight;
        this.price = price;
        this.arrivaldate = arrivaldate;
        this.recipient = recipient;
        this.transportid = transportid;
        this.postid = postid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public String getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(String departuredate) {
        this.departuredate = departuredate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    public int getTransportid() {
        return transportid;
    }

    public void setTransportid(int transportid) {
        this.transportid = transportid;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public void printItemInformation(){
        System.out.println(getId() + " " + getSender() + " " + getDeparturedate() + " " + getWeight() + " " + getPrice() + " " + getArrivaldate() + " " + getRecipient() + " " + getTransportid() + " " + getPostid());
    }
}
