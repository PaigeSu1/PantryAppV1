package com.example.pantryapp.database;

// Android / Room imports
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PantryItem.class}, version = 1)

public abstract class PantryDatabase extends RoomDatabase {

    private static PantryDatabase instance;

    public abstract PantryDao pantryDao();

    public static synchronized PantryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            PantryDatabase.class,
                            "pantry-db"
                    ).fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}

//Connects the app and database together