import biuoop.DrawSurface;

/**
 * The type Score indicator.
 * @author Daniel Levy
 * ID:208150433
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * Instantiates a new Score indicator.
     *
     * @param counter the counter
     */
    public ScoreIndicator(Counter counter) {
        this.score = counter;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(170, 30, "Score: " + this.score.getValue(), 30);
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
