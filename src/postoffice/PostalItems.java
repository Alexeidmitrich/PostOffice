package postoffice;

public class PostalItems {
    protected int id;
    protected String startDate;
    protected int weight;
    protected int price;
    protected String finishDate;
    protected String transport;

    public PostalItems(int id, String startDate, int weight, int price, String finishDate, String transport){
        this.id = id;
        this.startDate = startDate;
        this.weight = weight;
        this.price = price;
        this.finishDate = finishDate;
        this.transport = transport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }
    public void printAllPostalItems(){
        System.out.println(getId() + " " + getStartDate() + " " + getWeight() + " " + getPrice() + " " + getFinishDate() + " " + getTransport());
    }
}
