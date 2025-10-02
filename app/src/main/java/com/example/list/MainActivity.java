package com.example.list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ImageView imageView;
    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<Integer> imagesList = new ArrayList<>();
    ArrayList<String> imageNames = new ArrayList<>();
    ArrayList<String> imageNames2 = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        imageView = findViewById(R.id.imageView);

        idList.add(R.drawable.home);
        idList.add(R.drawable.graduationhat);
        idList.add(R.drawable.joystick);
        idList.add(R.drawable.school);
        idList.add(R.drawable.tree);

        imageNames.add("home");
        imageNames.add("hat");
        imageNames.add("joystick");
        imageNames.add("school");
        imageNames.add("tree");

        imagesList.add(R.drawable.banana);
        imagesList.add(R.drawable.orange);
        imagesList.add(R.drawable.cooking);
        imagesList.add(R.drawable.tomato);

        imageNames2.add("banana");
        imageNames2.add("orange");
        imageNames2.add("cooking");
        imageNames2.add("tomato");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, imageNames);
        listView.setAdapter(adapter);

        Intent intent = getIntent();
        if (intent.hasExtra("id")) {
            int id = intent.getIntExtra("id", -1);
            if (id >= 0 && id < imagesList.size()) {
                idList.add(imagesList.get(id));
                imageNames.add(imageNames2.get(id));
                adapter.notifyDataSetChanged();
            }
        }

        listView.setOnItemClickListener((parent, view, position, l) -> {
            imageView.setImageResource(idList.get(position));
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent navIntent = null;
            if (id == R.id.mnu_home) {
                navIntent = new Intent(this, MainActivity.class);
            } else if (id == R.id.mnu_add) {
                navIntent = new Intent(this, MainActivity2.class);
            }
            if (navIntent != null) {
                startActivity(navIntent);
                return true;
            }
            return false;
        });
    }
}