package com.example.john.seekbaractiv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    SeekBar seekBar;
    Button button1;
    Button button2;

    LinearLayout.LayoutParams lParams1;
    LinearLayout.LayoutParams lParams2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


        lParams1 = (LinearLayout.LayoutParams) button1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) button2.getLayoutParams();


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        int leftValue = i;
        int rightValue = seekBar.getMax() - i;

        lParams1.weight = leftValue;
        lParams2.weight = rightValue;

        button1.setText(String.valueOf(leftValue));
        button2.setText(String.valueOf(rightValue));



    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                seekBar.setProgress(0);
                break;
            case R.id.button2:
                seekBar.setProgress(100);
                break;
        }
    }
}
