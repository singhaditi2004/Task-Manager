package com.example.taskmanager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Button createtask,viewtask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        createtask=findViewById(R.id.create1);
        viewtask=findViewById(R.id.view1);
        createtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,create.class);
                startActivity(i);
            }
        });
        viewtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,view.class);
                startActivity(i);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Disable icon tinting programmatically
        bottomNavigationView.setItemIconTintList(null);

        Drawable activeDrawable = getResources().getDrawable(R.drawable.active_indicator);

        // Set up item selected listener
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Reset backgrounds for all items
                for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
                    MenuItem menuItem = bottomNavigationView.getMenu().getItem(i);
                    menuItem.setChecked(false);
                    bottomNavigationView.findViewById(menuItem.getItemId()).setBackground(null);
                }

                // Set the background for the selected item
                item.setChecked(true);
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    bottomNavigationView.findViewById(itemId).setBackground(activeDrawable);
                } else if (itemId == R.id.search) {
                    bottomNavigationView.findViewById(itemId).setBackground(activeDrawable);
                } else if (itemId == R.id.plus) {
                    bottomNavigationView.findViewById(itemId).setBackground(activeDrawable);
                } else if (itemId == R.id.profile) {
                    bottomNavigationView.findViewById(itemId).setBackground(activeDrawable);
                } else if (itemId == R.id.task) {
                    bottomNavigationView.findViewById(itemId).setBackground(activeDrawable);
                }

                return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}