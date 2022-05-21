package postoffice;

import java.util.ArrayList;
import java.util.List;

public class Postoffice {
    List<Sender> senderList = new ArrayList<>();
    List<Recipient> recipientList = new ArrayList<>();
    List<Letters> lettersList = new ArrayList<>();
    List<Parcels> parcelsList = new ArrayList<>();


    public void addLetters(int id, String startDate, int weight, int price, String finishDate, String transport){
        Letters letters = new Letters(id, startDate, weight, price, finishDate, transport);
        lettersList.add(letters);
    }
    public void addParcels(int id, String startDate, int weight, int price, String finishDate, String transport){
        Parcels parcels = new Parcels(id, startDate, weight, price, finishDate, transport);
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

