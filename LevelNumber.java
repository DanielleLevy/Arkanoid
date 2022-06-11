import biuoop.DrawSurface;

/**
 * The type Level number.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433 */
public class LevelNumber implements Sprite {
    private String name;

    /**
     * Instantiates a new Level number.
     *
     * @param n the name of the level
     */
    public LevelNumber(String n) {
        this.name = n;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(350, 30, "level name: " + this.name, 30);
    }

    @Override
    public void timePassed() {

    }

    /**
     * Add to game.
     *
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
