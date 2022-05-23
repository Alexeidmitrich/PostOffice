package postoffice.database;

import postoffice.PostalItems;

import java.util.List;

public interface AllPostItemDAO {
    List<PostalItems> getAllPostalItem();
    PostalItems getPostalItemsById(int id);
}
