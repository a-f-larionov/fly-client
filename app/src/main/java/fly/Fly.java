package fly;


public class Fly {

    private Game game = Game.getSingleton();

    private static Fly instance;

    private Fly() {

    }

    public static Fly getSingleton() {
        if (instance == null) {
            instance = new Fly();
        }
        return instance;
    }
}
