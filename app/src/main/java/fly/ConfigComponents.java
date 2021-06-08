package fly;

import android.annotation.SuppressLint;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class ConfigComponents {

    @SuppressLint("StaticFieldLeak")
    private static MainActivity mainActivity;

    public static void setActivity(MainActivity mainActivity) {
        System.out.println("SET ACTIVITY");
        ConfigComponents.mainActivity = mainActivity;
    }

    public static MainActivity getActivity() {
        return ConfigComponents.mainActivity;
    }

    @Provides
    public ScreenHelper getScreenHelper() {
        return new ScreenHelper();
    }

    @Provides
    public Fly getFly() {
        return new Fly();
    }

    @Provides
    public Game getGame() {
        return new Game();
    }

    @Provides
    public Score getScore() {
        return new Score();
    }

    @Provides
    public Timer getTimer() {
        return new Timer();
    }
}
