package postoffice.database;

import postoffice.Letters;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LettersDAOImpl extends  DBManager implements LettersDAO{


    @Override
    public List<Letters> getAllLetters() {
        List<Letters> lettersList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select lettersid,sender,departuredate,weight,price,arrivaldate,recipient,transport,post_id from postoffice.letters ");

            while (rs.next()) {
                Letters letters = new Letters(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8),rs.getInt(9));
                lettersList.add(letters);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lettersList;
    }

    @Override
    public Letters getLettersById(int id) {
        Letters letters = null;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select lettersid, sender, departuredate, weight, price, arrivaldate ,recipient,transport,post_id from letters " +
                    " WHERE lettersid = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            letters = new Letters(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getString(6), rs.getInt(7),rs.getString(8), rs.getInt(9));

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return letters;
    }

    @Override
    public void save(Letters letters) {
        try {
            Connection connection = getConnection();
            String sql = "insert into postoffice.letters (lettersid, sender, departuredate, weight, price, arrivaldate ,recipient,transport,post_id) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,letters.getId());
            statement.setInt(2, letters.getSender());
            statement.setString(3, letters.getDeparturedate());
            statement.setInt(4, letters.getWeight());
            statement.setInt(5,letters.getPrice());
            statement.setString(6,letters.getArrivaldate());
            statement.setInt(7,letters.getRecipient());
            statement.setString(8,letters.getTransport());
            statement.setInt(9,letters.getPostid());
            statement.execute();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
