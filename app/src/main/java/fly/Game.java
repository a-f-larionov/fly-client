package fly;

public class Game {

    private Fly fly;

    {
        fly = Fly.getSingleton();
    }

    private Game() {

    }

    private static Game instance;

    public static Game getSingleton() {

        if (instance == null) {
            instance = new Game();
        }

        return instance;
    }
}
