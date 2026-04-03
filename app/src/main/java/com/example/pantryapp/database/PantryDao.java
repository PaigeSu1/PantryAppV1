package com.example.pantryapp.database;

//Database function libaries
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface PantryDao {

    //How to talk to the database through functions
    @Insert
    void insert(PantryItem item); //saves all items

    @Update
    void update(PantryItem item);

    @Delete
    void delete(PantryItem item);

    @Query("SELECT * FROM pantry_items")
    List<PantryItem> getAllItems();
}