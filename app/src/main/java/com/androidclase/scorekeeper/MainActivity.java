package com.androidclase.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1 = 0;
    private int mScore2 = 0;

    private TextView mScoreText1;
    private TextView mScoreText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.team1Score);
        mScoreText2 = findViewById(R.id.team2Score);

        mScoreText1.setText(String.valueOf(mScore1));
        mScoreText2.setText(String.valueOf(mScore2));
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.team1Minus:
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.team2Minus:
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.team1Plus:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.team2Plus:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }
}