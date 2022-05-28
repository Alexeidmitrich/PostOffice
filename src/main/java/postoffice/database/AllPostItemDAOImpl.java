package postoffice.database;

import postoffice.PostalItems;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllPostItemDAOImpl extends DBManager implements AllPostItemDAO{

    @Override
    public List<PostalItems> getAllPostalItem() {
        List<PostalItems> postalItemsList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  * FROM postoffice.letters l UNION SELECT  * FROM postoffice.parcels p");

            while (rs.next()) {
              PostalItems postalItems = new PostalItems(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8),rs.getInt(9));
              postalItemsList.add(postalItems);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return postalItemsList;
    }

    @Override
    public PostalItems getPostalItemsById(int id) {
        PostalItems postalItems = null;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM postoffice.letters l UNION SELECT  * FROM postoffice.parcels p" +
                    " WHERE lettersid = ? or parcelsid = ?");
            statement.setInt(1, id);
            statement.setInt(2, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            postalItems = new PostalItems(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getString(6), rs.getInt(7),rs.getInt(8), rs.getInt(9));

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return postalItems;
    }
}
