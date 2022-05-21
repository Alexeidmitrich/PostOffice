package postoffice;

import java.util.ArrayList;
import java.util.List;

public class Postoffice {
    List<Sender> senderList = new ArrayList<>();
    List<Recipient> recipientList = new ArrayList<>();
    List<Letters> lettersList = new ArrayList<>();
    List<Parcels> parcelsList = new ArrayList<>();


    public void addLetters(int id, int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, String transport, int postid){
        Letters letters = new Letters(id, sender, departuredate, weight, price, arrivaldate, recipient, transport, postid);
        lettersList.add(letters);
    }
    public void addParcels(int id, int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, String transport, int postid){
        Parcels parcels = new Parcels(id, sender, departuredate, weight, price, arrivaldate, recipient, transport, postid);
        parcelsList.add(parcels);
    }
    public void addSender(String address, String firstname, String phone){
        Sender sender = new Sender(address,firstname,phone);
        senderList.add(sender);
    }
    public void addRecipient(String address, String firstname, String phone){
        Recipient recipient = new Recipient(address,firstname,phone);
        recipientList.add(recipient);
    }
    public void printSender(){
        for (int i = 0; i < senderList.size(); i++) {
            Sender sender = senderList.get(i);
            sender.printInformation();
        }
    }
    public void printRecipient(){
        for (int i = 0; i < recipientList.size(); i++) {
            Recipient recipient = recipientList.get(i);
            recipient.printInformation();
        }
    }
    public void printLetters(){
        for (int i = 0; i < lettersList.size(); i++) {
            Letters letters = lettersList.get(i);
            letters.printAllPostalItems();
        }
    }
    public void printParcels(){
        for (int i = 0; i < parcelsList.size(); i++) {
            Parcels parcels = parcelsList.get(i);
            parcels.printAllPostalItems();
        }
    }

    public static void main(String[] args) {
        Postoffice p = new Postoffice();
        p.addSender("Sankt-Petersburg", "Alex","+79211234567");
        p.addRecipient("Moscow", "Ivan","+79151234567");
        p.printSender();
        p.printRecipient();
    }
}

