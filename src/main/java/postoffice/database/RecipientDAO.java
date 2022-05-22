package postoffice.database;

import postoffice.Recipient;

import java.util.List;

public interface RecipientDAO {

    List<Recipient> getAllRecipient();
    Recipient getRecipientById(int id);
    void save(Recipient recipient);
}
