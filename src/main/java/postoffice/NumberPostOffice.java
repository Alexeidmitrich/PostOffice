package postoffice;

public class NumberPostOffice {
    private int id;
    private String city;

    public NumberPostOffice(int id, String city){
        this.id = id;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}

