package com.example.taskmanager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import java.util.HashSet;

public class dialogFragment extends DialogFragment {
    public HashSet<String> category=new HashSet<>();
    Chip chipCpp, chipJava, chipPython;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_layout, container, false);
        chipCpp = view.findViewById(R.id.chip1);
        chipJava = view.findViewById(R.id.chip2);
        chipPython = view.findViewById(R.id.chip3);

        TextView textview=view.findViewById(R.id.flagtext);
        chipCpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check whether the chips is filtered by user
                // or not and give the suitable Toast message
                if (chipCpp.isChecked()) {
                    Toast.makeText(getContext(), "Work category selected", Toast.LENGTH_SHORT).show();
                    category.add("work");
                } else {
                    Toast.makeText(getContext(), "Work category deselected", Toast.LENGTH_SHORT).show();
                    category.remove("work");
                }
            }
        });

        chipJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check whether the chips is filtered by user or
                // not and give the suitable Toast message
                if (chipJava.isChecked()) {
                    Toast.makeText(getContext(), "Personal category selected", Toast.LENGTH_SHORT).show();
                    category.add("personal");
                } else {
                    Toast.makeText(getContext(), "Personal category deselected", Toast.LENGTH_SHORT).show();
                    category.remove("personal");
                }
            }
        });

        chipPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check whether the chips is filtered by user or
                // not and give the suitable Toast message
                if (chipPython.isChecked()) {
                    Toast.makeText(getContext(), "Errands category selected", Toast.LENGTH_SHORT).show();
                    category.add("errands");
                } else {
                    Toast.makeText(getContext(), "Errands deselected", Toast.LENGTH_SHORT).show();
                    category.remove("errands");

                }
            }
        });

        return view;
    }
}
