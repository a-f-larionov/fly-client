package fly;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class ConfigComponents {

    @Provides
    public Fly getFly() {
        return new Fly();
    }

    @Provides
    public Game getGame() {
        return new Game();
    }
}
