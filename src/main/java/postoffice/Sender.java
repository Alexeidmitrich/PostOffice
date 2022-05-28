package postoffice;

public class Sender extends Person{

    public Sender(int id, String city, String street, String numberhouse, String housebuilding, String flat, String firstname, String lastname, String phone, NumberPostOffice numberPostOffice) {
        super(id, city, street, numberhouse, housebuilding, flat, firstname, lastname, phone, numberPostOffice);
    }

    public Sender(String city, String street, String numberhouse, String housebuilding, String flat, String firstname, String lastname, String phone) {
        super(city, street, numberhouse, housebuilding, flat, firstname, lastname, phone);
    }
}
