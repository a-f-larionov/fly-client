package fly;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Timer {

    private TextView text;
    private long startTimestamp;
    private Runnable onFinishCallback;

    Timer(TextView timerText) {
        text = timerText;
        loop();
    }

    private void loop() {
        Runnable runnable;
        runnable = new Runnable() {
            @Override
            public void run() {
                onIdle();
                loop();
            }
        };
        new Handler().postDelayed(runnable, 35);
    }

    public void start(long millis) {
        startTimestamp = System.currentTimeMillis() + millis;
        text.setVisibility(View.VISIBLE);
    }

    public void stop() {
        text.setVisibility(View.INVISIBLE);
    }

    private void onIdle() {
        long fullT, otherT;
        String txt;
        fullT = ((startTimestamp - System.currentTimeMillis()) / 1000);
        otherT = (startTimestamp - System.currentTimeMillis()) - 1000 * fullT;
        txt = "" + fullT + "." + otherT + " сек";
        text.setText(txt);
        if ((System.currentTimeMillis() - startTimestamp) < 0) {
            Log.i("tag", "finished");
            stop();
            onFinishCallback.run();
        }
    }

    public void setOnTimeoutCallback(Runnable runnable) {
        onFinishCallback = runnable;
    }
}
