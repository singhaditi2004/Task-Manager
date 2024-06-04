package com.example.taskmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.TimePicker;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;

public class dialogtime extends DialogFragment {
    Button day,week,month,speci;
    TextView date;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogtime, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        day=view.findViewById(R.id.daily);
        week=view.findViewById(R.id.weekly);
        speci=view.findViewById(R.id.specific);
        date=view.findViewById(R.id.datespeci);
        speci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Daily remainder set", Toast.LENGTH_SHORT).show();

            }
        });
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Weekly remainder set", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }




    public void openDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                //Showing the picked value in the textView
                date.setText(String.valueOf(year)+ "."+String.valueOf(month)+ "."+String.valueOf(day));

            }
        }, 2023, 01, 20);

        datePickerDialog.show();
    }
}
