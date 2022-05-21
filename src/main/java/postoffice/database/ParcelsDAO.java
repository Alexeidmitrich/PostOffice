package postoffice.database;

import postoffice.Parcels;

import java.util.List;

public interface ParcelsDAO {
    List<Parcels> getAllParcels();
    Parcels getParcelsById(int id);
    void save(Parcels parcels);
}
