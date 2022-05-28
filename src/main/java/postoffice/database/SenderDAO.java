package postoffice.database;

import postoffice.Recipient;
import postoffice.Sender;

import java.util.List;

public interface SenderDAO {
    List<Sender> getAllSender();
    Sender getSenderById(int id);

    Sender getSenderName(String firstname, String lastname);
    void save(Sender sender, int postofficeId);
}
