package postoffice.database;

import postoffice.Letters;

import java.util.List;

public interface LettersDAO {

    List<Letters> getAllLetters();
    Letters getLettersById(int id);
    void save(Letters letters);
}

