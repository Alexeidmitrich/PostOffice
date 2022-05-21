package postoffice;

public class Recipient extends  Person{

    public Recipient(String address, String firstname, String phone) {
        super(address, firstname, phone);
    }
    public  void printAllRecipient(){
        System.out.println(getAddress() + " " + getFirstname() + " " + getPhone());
    }
}
