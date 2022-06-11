import biuoop.DrawSurface;


/**
 * The type End screen.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class EndScreen implements Animation {
    private boolean win;
    private Counter score;

    /**
     * Instantiates a new End screen.
     *
     * @param win is the player win?
     * @param s   the score
     */
    public EndScreen(boolean win, Counter s) {
        this.win = win;
        this.score = s;
    }
@Override
    public void doOneFrame(DrawSurface d) {
        if (win) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.score.getValue(), 32);
        } else {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + this.score.getValue(), 32);
        }
    }
@Override
    public boolean shouldStop() {
        return false;
    }
}

