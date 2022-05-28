package postoffice.database;

import postoffice.NumberPostOffice;
import postoffice.Recipient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipientDAOImpl extends DBManager implements RecipientDAO{
    @Override
    public List<Recipient> getAllRecipient() {
       List<Recipient> recipientList = new ArrayList<>();
        Connection connection = getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from postoffice.recipient");

            while (rs.next()) {
                NumberPostOffice numberPostOffice = new NumberPostOffice(rs.getInt("postid"), rs.getString("city"));
                Recipient recipient = new Recipient(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),numberPostOffice);
                recipientList.add(recipient);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return recipientList;
    }

    @Override
    public Recipient getRecipientById(int id) {
        Recipient recipient = null;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from postoffice.recipient " +
                    " WHERE recipientid = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            NumberPostOffice numberPostOffice = new NumberPostOffice(rs.getInt("postid"), rs.getString("city"));
            recipient = new Recipient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),numberPostOffice);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return recipient;
    }

    @Override
    public Recipient getRecipientByName(String firstname, String lastname) {
        Recipient recipient = null;
        Connection connection = getConnection();
        try {
            String sql = "select recipientid,r.city, r.street, r.numberhouse , r.housebuilding, r.flat, r.firstname, r.lastname, r.phone , p.postid , p.city from postoffice.recipient r"+
                    "inner join postoffice.postoffice p on r.post_id = p.postid  WHERE firstname = ? and lastname = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,firstname);
            statement.setString(2,lastname);
            ResultSet rs = statement.executeQuery();
            rs.next();
            NumberPostOffice numberPostOffice = new NumberPostOffice(rs.getInt("postid"), rs.getString("city"));
            recipient = new Recipient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),numberPostOffice);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return recipient;
    }

    @Override
    public void save(Recipient recipient, int postofficeId) {
        try {
            Connection connection = getConnection();
            String sql = "insert into postoffice.recipient (recipientid,city, street, numberhouse, housebuilding,flat,firstname, lastname, phone, post_id) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,recipient.getId());
            statement.setString(2,recipient.getCity() );
            statement.setString(3, recipient.getStreet());
            statement.setString(4, recipient.getNumberhouse());
            statement.setString(5, recipient.getHousebuilding());
            statement.setString(6, recipient.getFlat());
            statement.setString(7, recipient.getFirstname());
            statement.setString(8, recipient.getLastname());
            statement.setString(9, recipient.getPhone());
            statement.setInt(10,postofficeId);
            statement.execute();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
