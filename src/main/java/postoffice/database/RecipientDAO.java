package postoffice.database;

import postoffice.Recipient;
import postoffice.Sender;

import java.util.List;

public interface RecipientDAO {

    List<Recipient> getAllRecipient();
    Recipient getRecipientById(int id);
    Recipient getRecipientByName(String firstname, String lastname);
    void save(Recipient recipient, int postofficeId);
}
