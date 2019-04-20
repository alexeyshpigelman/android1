package com.example.sapirsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.RatingBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textViewSets , textViewReps;
    private ProgressBar setsProgressBar , repsProgressBar;
    private SeekBar setsSeekBar , repsSeeBar;
    private RatingBar ratingBarSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner_activity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.name_activity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);

        textViewSets = (TextView) findViewById(R.id.number_of_sets_text);
        setsProgressBar = (ProgressBar) findViewById(R.id.setsProgressBar);
        setsSeekBar = (SeekBar) findViewById(R.id.setsSeekBar);
        textViewReps = (TextView) findViewById(R.id.number_of_reps_text);
        repsProgressBar = (ProgressBar) findViewById(R.id.repsProgressBar);
        repsSeeBar = (SeekBar) findViewById(R.id.repsSeekBar);

        ratingBarSpace = (RatingBar) findViewById(R.id.ratingBar_space_luc);
        ratingBarSpace.setNumStars(5);

        setsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setsProgressBar.setProgress(progress);
                textViewSets.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        repsSeeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                repsProgressBar.setProgress(progress);
                textViewReps.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratingBarSpace.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this , (int)rating , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, radioButton.getText(),
                Toast.LENGTH_SHORT).show();
    }


}

