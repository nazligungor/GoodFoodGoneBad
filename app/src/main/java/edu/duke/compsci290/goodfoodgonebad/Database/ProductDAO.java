package edu.duke.compsci290.goodfoodgonebad.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by nazligungor on 26.04.2018.
 */
@Dao
@TypeConverters(DataConverter.class)
public interface ProductDAO {
    // Adds an item to the database
    @Insert
    void insert(Product item);

    // Removes an item from the database
    @Delete
    void delete(Product item);

    @Update
    void update(Product item);

    // Gets all items in the database
    @Query("SELECT * FROM product order by expiration")
    LiveData<List<Product>> getAllEntries();

    // Gets all items in the database with a specific expiration
    @Query("SELECT * FROM product WHERE expiration LIKE :expiration")
    LiveData<List<Product>> getExpiredEntries(String expiration);

    // ERROR NOTE: Fails to get product by name on click
    @Query("SELECT * FROM product where name like:name")
    Product getObjectbyname(String name);


}
