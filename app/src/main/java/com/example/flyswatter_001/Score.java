package com.example.flyswatter_001;

import android.widget.TextView;

public class Score {

    int score = 0;
    TextView text;

    Score(TextView scoreText) {
        text = scoreText;
    }

    public void increase(int value) {
        score += value;

        String txt = "Очков: " + score;
        text.setText(txt);
    }
}
