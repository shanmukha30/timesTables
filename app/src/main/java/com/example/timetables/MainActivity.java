package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public void generateTable(int t){
        ArrayList<String> c = new ArrayList<String>();
        for(int i = 1;i<=15;i++){
            c.add(Integer.toString(t*i));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,c);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar sk = (SeekBar) findViewById(R.id.seekBar);
        listView = (ListView) findViewById(R.id.listView);
        sk.setMax(20);
        sk.setProgress(10);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int t;
                if (progress<min){
                    t=1;
                    sk.setProgress(min);
                }else{
                    t=progress;
                }
                generateTable(t);
            }

            @Override
            public void onStartTrackingTouch(SeekBar sk) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar sk) {

            }
        });
        generateTable(10);
    }
}