package com.example.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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
    }

    public void cancle(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void ad(View view) {
        EditText idd = findViewById(R.id.id);
        if (idd != null && !idd.getText().toString().isEmpty()) {
            int id = Integer.parseInt(idd.getText().toString());
            id--;
            if (id >= 0 && id < 4) {
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            } else {
                Toast.makeText(this, "دخل رقم بين 1 و 4", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "ادخل رقم", Toast.LENGTH_SHORT).show();
        }
    }
}
