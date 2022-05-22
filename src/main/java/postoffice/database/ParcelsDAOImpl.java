package postoffice.database;


import postoffice.Parcels;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParcelsDAOImpl extends  DBManager implements ParcelsDAO{
    @Override
    public List<Parcels> getAllParcels() {
        List<Parcels> parcelsList= new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select parcelsid,sender,departuredate,weight,price,arrivaldate,recipient,transport,post_id from postoffice.letters ");

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
                Parcels parcels = new Parcels(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8),rs.getInt(9));
                parcelsList.add(parcels);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return parcelsList;
    }

    @Override
    public Parcels getParcelsById(int id) {
        Parcels parcels = null;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select parcelsid, sender, departuredate, weight, price, arrivaldate ,recipient,transport,post_id from postoffice.parcels " +
                    " WHERE parcelsid = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            parcels = new Parcels(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getString(6), rs.getInt(7),rs.getString(8), rs.getInt(9));

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return parcels;
    }

    @Override
    public void save(Parcels parcels) {
        try {
            Connection connection = getConnection();
            String sql = "insert into postoffice.parcels (parcelsid, sender, departuredate, weight, price, arrivaldate ,recipient,transport,post_id) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,parcels.getId());
            statement.setInt(2, parcels.getSender());
            statement.setString(3, parcels.getDeparturedate());
            statement.setInt(4, parcels.getWeight());
            statement.setInt(5,parcels.getPrice());
            statement.setString(6,parcels.getArrivaldate());
            statement.setInt(7,parcels.getRecipient());
            statement.setString(8,parcels.getTransport());
            statement.setInt(9,parcels.getPostid());
            statement.execute();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
