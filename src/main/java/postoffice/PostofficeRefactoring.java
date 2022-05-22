package postoffice;

import postoffice.database.*;

import java.util.List;

public class PostofficeRefactoring extends Postoffice {

    private DBManager dbManager = new DBManager();
    private LettersDAO lettersDAO = new LettersDAOImpl();
    private ParcelsDAO parcelsDAO = new ParcelsDAOImpl();
    private RecipientDAO recipientDAO = new RecipientDAOImpl();
    private SenderDAO senderDAO = new SenderDAOImpl();

    @Override
    public void addLetters(int id, int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, String transport, int postid) {
        Letters letters = new Letters(id, sender, departuredate, weight, price, arrivaldate, recipient, transport, postid);
        lettersDAO.save(letters);
    }

    @Override
    public void addParcels(int id, int sender, String departuredate, int weight, int price, String arrivaldate, int recipient, String transport, int postid) {
        Parcels parcels = new Parcels(id, sender, departuredate, weight, price, arrivaldate, recipient, transport, postid);
        parcelsDAO.save(parcels);
    }

    @Override
    public void addSender(int id, String city, String street, String numberhouse, String housebuilding, String flat, String firstname, String lastname, String phone, int postid) {
        Sender sender = new Sender(id, city, street, numberhouse, housebuilding, flat, firstname, lastname, phone, postid);
        senderDAO.save(sender);
    }

    @Override
    public void addRecipient(int id, String city, String street, String numberhouse, String housebuilding, String flat, String firstname, String lastname, String phone, int postid) {
        Recipient recipient = new Recipient(id, city, street, numberhouse, housebuilding, flat, firstname, lastname, phone, postid);
        recipientDAO.save(recipient);
    }

    @Override
    public void printSender() {
        List<Sender> senders = senderDAO.getAllSender();
        for (int i = 0; i < senders.size(); i++) {
            Sender sender = senders.get(i);
            sender.printInformation();
        }
    }

    @Override
    public void printRecipient() {
        List<Recipient> recipients = recipientDAO.getAllRecipient();
        for (int i = 0; i < recipients.size(); i++) {
            Recipient recipient = recipients.get(i);
            recipient.printInformation();
        }
    }

    @Override
    public void printLetters() {
        List<Letters> letters = lettersDAO.getAllLetters();
        for (int i = 0; i < letters.size(); i++) {
         Letters letter = letters.get(i);
         letter.printAllPostalItems();
        }
    }

    @Override
    public void printParcels() {
        List<Parcels> parcels = parcelsDAO.getAllParcels();
        for (int i = 0; i < parcels.size(); i++) {
            Parcels parcel = parcels.get(i);
            parcel.printAllPostalItems();
        }
    }
}