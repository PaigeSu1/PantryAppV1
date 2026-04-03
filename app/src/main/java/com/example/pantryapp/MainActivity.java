//Currently connects to A data base and is able to take in items and diplay on a basic UI Output


package com.example.pantryapp;

import com.example.pantryapp.R;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pantryapp.adapter.PantryAdapter;
import com.example.pantryapp.database.PantryDatabase;
import com.example.pantryapp.database.PantryItem;
import java.util.List;

//Made with version 2024 1.1 koala
//libraries will need to change to sdk 36 to use the scanner


public class MainActivity extends AppCompatActivity {

    private PantryDatabase db;
    private RecyclerView recyclerView;
    private PantryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = PantryDatabase.getInstance(getApplicationContext()); // make sure you have a singleton getter in AppDatabase

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addTestItems(); // optional test items
        loadPantryItems();
    }

    private void loadPantryItems() {
        new Thread(() -> {
            List<PantryItem> items = db.pantryDao().getAllItems();

            runOnUiThread(() -> {
                adapter = new PantryAdapter(items);
                recyclerView.setAdapter(adapter);
            });
        }).start();
    }

    //testing od adding item to database
    private void addTestItems() {
        new Thread(() -> {
            PantryItem item1 = new PantryItem("Apples", 5, System.currentTimeMillis() + 86400000);
            PantryItem item2 = new PantryItem("Milk", 2, System.currentTimeMillis() + 43200000);
            db.pantryDao().insert(item1);
            db.pantryDao().insert(item2);

            // Reload after inserting
            loadPantryItems();
        }).start();
    }
}