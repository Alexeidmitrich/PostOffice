package postoffice;

public class Recipient extends  Person{

    public Recipient(int id, String city, String street, String numberhouse, String housebuilding, String flat, String firstname, String lastname, String phone, int postid) {
        super(id, city, street, numberhouse, housebuilding, flat, firstname, lastname, phone, postid);
    }

    public Recipient(String city, String street, String numberhouse, String housebuilding, String flat, String firstname, String lastname, String phone, int postid) {
        super(city, street, numberhouse, housebuilding, flat, firstname, lastname, phone, postid);
    }
}
