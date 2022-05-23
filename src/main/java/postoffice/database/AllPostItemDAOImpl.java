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
            ResultSet rs = stmt.executeQuery("select * from postoffice.letters l, postoffice.parcels p ");

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
                PostalItems postalItems = new PostalItems(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8),rs.getInt(9));
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
            PreparedStatement statement = connection.prepareStatement("select * from postoffice.letters, postoffice.parcels " +
                    " WHERE lettersid = ?  and parcelsid = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            postalItems = new PostalItems(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getString(6), rs.getInt(7),rs.getString(8), rs.getInt(9));

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return postalItems;
    }
}
