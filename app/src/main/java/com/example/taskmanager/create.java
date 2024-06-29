package com.example.taskmanager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class create extends AppCompatActivity {
    private Switch switchView;
    Button sub,category;
    TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create);
        switchView=findViewById(R.id.addremainder);
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Replace the content view with dialogtime fragment
                    getSupportFragmentManager().beginTransaction()
                            .replace(android.R.id.content, new dialogtime())
                            .commit();
                }
            }
        });
        sub=findViewById(R.id.subtask);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new subtaskk()) // Use android.R.id.content to replace the entire content view
                        .addToBackStack(null) // Add fragment transaction to back stack
                        .commit();
            }
        });
        List<String> items = Arrays.asList("Material", "Design", "Components", "Android");

        // Find the TextInputLayout
        TextInputLayout textField = findViewById(R.id.dropdown);

        // Create an ArrayAdapter with the list of items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, items);

        // Get the AutoCompleteTextView from the TextInputLayout and set the adapter
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textField.getEditText();
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setAdapter(adapter);
        }
        category=findViewById(R.id.category);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFragment dialog = new dialogFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Instead of adding, let's replace the content with the dialogFragment
                transaction.replace(android.R.id.content, dialog, "dialog_fragment_tag");

                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        date=findViewById(R.id.due);
                date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void openDatePicker() {
        // Get today's date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(create.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // Month is 0-based, so add 1 to get the correct month
                month += 1;
                // Format the selected date
                String selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%02d", day, month, year % 100);
                // Showing the picked value in the textView
                date.setText(selectedDate);
            }
        }, year, month, day);

        // Set the minimum date to today's date
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());

        // Show the date picker dialog
        datePickerDialog.show();
    }

}