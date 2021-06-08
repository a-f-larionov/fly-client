package fly;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ImageView flyImage;

    @Inject
    public Score score;

    @Inject
    public Timer timer;

    @Inject
    public Fly fly;

    @Inject
    public Game game;

    @Inject
    public ScreenHelper screenHelper;

    private long catchTimeout = 1000 * 2;
    private int nextFlyMaxTimeout = 1000 * 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConfigComponents.setActivity(this);

        // Must be BEFORE screenHelper.setFullScreen
        screenHelper.setFullScreen();
        setContentView(R.layout.activity_main);

        screenHelper.onCreateActivity();
        score.onCreateActivity();
        timer.onCreateActivity();
        fly.onCreateActivity();

        flyImage = findViewById(R.id.flyImage);

        timer.setOnTimeoutCallback(() -> onTimeout());

        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                onClickFly();
            }
        };

        flyImage.setOnClickListener(oclBtn);

        delayedActions();
    }

    private void onTimeout() {
        /**
         * show Проиграл
         */

        // save score


    }

    public void showFly() {
        int x, y;
        x = (int) ((screenHelper.getWidth() - flyImage.getWidth() - 10) * Math.random());
        y = (int) ((screenHelper.getHeight() - flyImage.getHeight() - 10 - 100) * Math.random());


        flyImage.setX(x);
        flyImage.setY(y);
        flyImage.setVisibility(ImageView.VISIBLE);

        timer.start(catchTimeout);
    }

    private void delayedActions() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                delayedShowFly();
                delayedIncreaseScore();
                delayedTimeoutCheck();
            }
        };
        new Handler().postDelayed(runnable, 1500);
    }

    private void delayedTimeoutCheck() {
        Runnable runnable;
        runnable = new Runnable() {
            @Override
            public void run() {
                //timeoutCheck();
                delayedTimeoutCheck();
            }
        };
        new Handler().postDelayed(runnable, 35);
    }

    private void delayedIncreaseScore() {
        Runnable runnable;
        runnable = new Runnable() {
            @Override
            public void run() {
                score.increase(1);
                delayedIncreaseScore();
            }
        };
        new Handler().postDelayed(runnable, 1500);
    }

    private void delayedShowFly() {
        Runnable runnable;
        runnable = new Runnable() {
            @Override
            public void run() {
                showFly();
            }
        };
        new Handler().postDelayed(runnable, (int) (Math.random() * nextFlyMaxTimeout));
    }

    public void onClickFly() {
        score.increase(100);
        catchTimeout -= 100;
        nextFlyMaxTimeout -= 100;
        flyImage.setVisibility(View.GONE);
        timer.stop();
        delayedShowFly();
    }
}
