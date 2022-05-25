package postoffice;

import postoffice.database.*;

import java.util.List;

public class PostofficeRefactoring{

    private DBManager dbManager = new DBManager();
    private LettersDAO lettersDAO = new LettersDAOImpl();
    private ParcelsDAO parcelsDAO = new ParcelsDAOImpl();
    private RecipientDAO recipientDAO = new RecipientDAOImpl();
    private SenderDAO senderDAO = new SenderDAOImpl();
    private AllPostItemDAO allPostItemDAO = new AllPostItemDAOImpl();
    private ParcelsDAOImpl parcelsDAOImpl;
    private LettersDAOImpl lettersDAOImpl;
    private RecipientDAOImpl recipientDAOImpl;
    private SenderDAOImpl senderDAOImpl;

    public void addLetters(int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, String transport, int postid) {
        Letters letters = new Letters(sender, departuredate, weight, price, arrivaldate, recipient, transport, postid);
        lettersDAO.save(letters);
    }


    public void addParcels(int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, String transport, int postid) {
        Parcels parcels = new Parcels(sender, departuredate, weight, price, arrivaldate, recipient, transport, postid);
        parcelsDAO.save(parcels);
    }

    public void addSender(String city, String street, String numberhouse, String housebuilding, String flat, String firstname, String lastname, String phone, int postid) {
        Sender sender = new Sender(city, street, numberhouse, housebuilding, flat, firstname, lastname, phone, postid);
        senderDAO.save(sender);
    }


    public void addRecipient(String city, String street, String numberhouse, String housebuilding, String flat, String firstname, String lastname, String phone, int postid) {
        Recipient recipient = new Recipient(city, street, numberhouse, housebuilding, flat, firstname, lastname, phone, postid);
        recipientDAO.save(recipient);
    }


    public void printSender() {
        List<Sender> senders = senderDAO.getAllSender();
        for (int i = 0; i < senders.size(); i++) {
            Sender sender = senders.get(i);
            sender.printInformation();
        }
    }


    public void printRecipient() {
        List<Recipient> recipients = recipientDAO.getAllRecipient();
        for (int i = 0; i < recipients.size(); i++) {
            Recipient recipient = recipients.get(i);
            recipient.printInformation();
        }
    }


    public void printLetters() {
        List<Letters> letters = lettersDAO.getAllLetters();
        for (int i = 0; i < letters.size(); i++) {
            Letters letter = letters.get(i);
            letter.printItemInformation();
        }
    }


    public void printParcels() {
        List<Parcels> parcels = parcelsDAO.getAllParcels();
        for (int i = 0; i < parcels.size(); i++) {
            Parcels parcel = parcels.get(i);
            parcel.printItemInformation();
        }
    }

    public void printAllPostItem() {
        List<PostalItems> postalItems = allPostItemDAO.getAllPostalItem();
        for (int i = 0; i < postalItems.size(); i++) {
            PostalItems postalItem = postalItems.get(i);
            postalItem.printItemInformation();
        }
    }
    public void printOneParcelId(int id){
        ParcelsDAOImpl parcelsDAOImpl = new ParcelsDAOImpl();
        Parcels p = parcelsDAOImpl.getParcelsById(id);
        p.printItemInformation();
    }
    public void printOneLettersId(int id){
        LettersDAOImpl lettersDAOImpl = new LettersDAOImpl();
        Letters p = lettersDAOImpl.getLettersById(id);
        p.printItemInformation();
    }
    public void printItemForRecipientName(String firstname, String lastname){
        RecipientDAOImpl recipientDAOImpl = new RecipientDAOImpl();
        Recipient p = recipientDAOImpl.getRecipientByName(firstname,lastname);
        p.printInformation();
    }
    public void printItemForSenderName(String firstname, String lastname){
        SenderDAOImpl senderDAOImpl = new SenderDAOImpl();
        Sender p = senderDAOImpl.getSenderName(firstname, lastname);
        p.printInformation();
    }
}