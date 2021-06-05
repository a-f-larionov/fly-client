package fly;

import android.widget.TextView;

public class Score {

    private int score = 0;
    private TextView text;

    Score(TextView scoreText) {
        text = scoreText;
    }

    public void increase(int value) {
        score += value;

        String txt = "Очков: " + score;
        text.setText(txt);
    }
}
