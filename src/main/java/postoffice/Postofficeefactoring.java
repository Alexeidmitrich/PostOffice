package postoffice;

import postoffice.database.*;

public class Postofficeefactoring extends Postoffice {

    private DBManager dbManager = new DBManager();
    private LettersDAO lettersDAO = new LettersDAOImpl();
    private ParcelsDAO parcelsDAO = new ParcelsDAOImpl();

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
}