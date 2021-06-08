package fly;

import android.widget.TextView;

import org.w3c.dom.Text;

public class Score {

    private int score = 0;
    private TextView text;

    public void onCreateActivity() {
        text = (TextView) ConfigComponents.getActivity().findViewById(R.id.scoreText);
    }

    public void increase(int value) {
        score += value;

        String txt = "Очков: " + score;
        text.setText(txt);
    }
}
