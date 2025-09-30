package com.example.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ImageView imageView;
    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<String> imageNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idList.add(R.drawable.home);
        idList.add(R.drawable.graduationhat);
        idList.add(R.drawable.joystick);
        idList.add(R.drawable.school);

        imageNames.add("home");
        imageNames.add("hat");
        imageNames.add("joystick");
        imageNames.add("school");
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent intent = null;

            if (id == R.id.mnu_home) {
                intent = new Intent(this, MainActivity.class);
            } else if (id == R.id.mnu_add) {
                intent = new Intent(this, MainActivity2.class);
            }
            if (intent != null) {
                startActivity(intent);
                return true;
            }
            return false;
        });

        Intent intent = getIntent();
        if (intent.hasExtra("id")) {
            int id = intent.getIntExtra("id",0);

        }

        listView = findViewById(R.id.listView);
        imageView = findViewById(R.id.imageView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, imageNames);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(idList.get(position));
            }
        });
    }
}