package com.sachinapp.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ListView listView;
    ArrayList<String> table = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.list);

        for(int i=1; i<=10; i++)
        {
            table.add("1 * " + i + " = " + i);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, table);

        listView.setAdapter(arrayAdapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(MainActivity.this, "You have clicked" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();

                multiTable(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(MainActivity.this, "You have clicked" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void multiTable(int value)
    {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, table);

        for(int i=1; i<=table.size(); i++)
        {
            table.set(i-1, value + " * " + i + " = " + value * i);
        }

        listView.setAdapter(arrayAdapter);

    }
}