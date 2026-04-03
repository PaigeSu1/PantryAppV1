/*
This is a class that addes the item into the database
 */

package com.example.pantryapp.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pantry_items")
public class PantryItem {
    //Create the database table
    //id               auto number
    //name             item name
    //barcode          scannded code
    //expirationDate   reimders

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public int quantity;
    public long expirationDate; //represents the time stamp

    public PantryItem(String name, int quantity, long expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }
}