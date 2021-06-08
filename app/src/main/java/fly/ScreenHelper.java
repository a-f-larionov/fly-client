package fly;

import android.graphics.Point;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class ScreenHelper {

    private int screenWidth;

    private int screenHeight;

    public void onCreateActivity() {

        Display display = ConfigComponents.getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
    }

    public void setFullScreen() {
        ConfigComponents.getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);
        ConfigComponents.getActivity().getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
    }

    public int getWidth() {
        return screenWidth;
    }

    public int getHeight() {
        return screenHeight;
    }
}
