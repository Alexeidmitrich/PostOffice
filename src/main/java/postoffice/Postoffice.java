package postoffice;

import java.util.ArrayList;
import java.util.List;

public class Postoffice {
    List<Sender> senderList = new ArrayList<>();
    List<Recipient> recipientList = new ArrayList<>();
    List<Letters> lettersList = new ArrayList<>();
    List<Parcels> parcelsList = new ArrayList<>();
    List<PostalItems> postalItemsList = new ArrayList<>();



    public void addLetters(int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, String transport, int postid){
        Letters letters = new Letters(sender, departuredate, weight, price, arrivaldate, recipient, transport, postid);
        lettersList.add(letters);
        postalItemsList.add(letters);
    }
    public void addParcels(int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, String transport, int postid){
        Parcels parcels = new Parcels(sender, departuredate, weight, price, arrivaldate, recipient, transport, postid);
        parcelsList.add(parcels);
        postalItemsList.add(parcels);
    }
    public void addSender(String city, String street, String numberhouse, String housebuilding, String flat, String firstname, String lastname, String phone, int postid){
        Sender sender = new Sender(city, street, numberhouse, housebuilding, flat, firstname, lastname, phone, postid);
        senderList.add(sender);
    }
    public void addRecipient(String city, String street, String numberhouse, String housebuilding, String flat, String firstname, String lastname, String phone, int postid){
        Recipient recipient = new Recipient(city, street, numberhouse, housebuilding, flat, firstname, lastname, phone, postid);
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
            letters.printItemInformation();
        }
    }
    public void printParcels(){
        for (int i = 0; i < parcelsList.size(); i++) {
            Parcels parcels = parcelsList.get(i);
            parcels.printItemInformation();
        }
    }
    public  void printAllPostItem(){
        for (int i = 0; i < postalItemsList.size(); i++) {
           PostalItems postalItems = postalItemsList.get(i);
           postalItems.printItemInformation();
        }
    }

    public static void main(String[] args) {
        Postoffice p = new Postoffice();
    }
}

