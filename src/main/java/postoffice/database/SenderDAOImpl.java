package postoffice.database;

import postoffice.NumberPostOffice;
import postoffice.Sender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SenderDAOImpl extends DBManager implements SenderDAO{
    @Override
    public List<Sender> getAllSender() {
        List<Sender> senderList = new ArrayList<>();
        Connection connection = getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select senderid,city, street, numberhouse, housebuilding,flat,firstname, lastname, phone, post_id from postoffice.sender");

            while (rs.next()) {
                NumberPostOffice numberPostOffice = new NumberPostOffice(rs.getInt("postid"), rs.getString("city"));
                Sender sender = new Sender(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),numberPostOffice);
                senderList.add(sender);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return senderList;
    }

    @Override
    public Sender getSenderById(int id) {
        Sender sender = null;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from postoffice.sender " +
                    " WHERE sendersid = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            NumberPostOffice numberPostOffice = new NumberPostOffice(rs.getInt("postid"), rs.getString("city"));
            sender = new Sender(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),numberPostOffice);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sender;
    }

    @Override
    public Sender getSenderName(String firstname, String lastname) {
        Sender sender = null;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from postoffice.sender " +
                    " WHERE firstname = ? and lastname = ?");
            statement.setString(1,firstname);
            statement.setString(2,lastname);
            ResultSet rs = statement.executeQuery();
            rs.next();
            NumberPostOffice numberPostOffice = new NumberPostOffice(rs.getInt("postid"), rs.getString("city"));
            sender = new Sender(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9), numberPostOffice);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sender;
    }

    @Override
    public void save(Sender sender, int postofficeId) {
        try {
            Connection connection = getConnection();
            String sql = "insert into postoffice.sender (senderid,city, street, numberhouse, housebuilding,flat,firstname, lastname, phone, post_id) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, sender.getId());
            statement.setString(2, sender.getCity() );
            statement.setString(3, sender.getStreet());
            statement.setString(4, sender.getNumberhouse());
            statement.setString(5, sender.getHousebuilding());
            statement.setString(6, sender.getFlat());
            statement.setString(7, sender.getFirstname());
            statement.setString(8, sender.getLastname());
            statement.setString(9, sender.getPhone());
            statement.setInt(10, postofficeId);
            statement.execute();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
