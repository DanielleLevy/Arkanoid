import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Countdown animation.
 *  The CountdownAnimation will display the given gameScreen.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */

public class CountdownAnimation implements Animation {
    private boolean running;
    private double numOfSec;
    private int countFrom;
    private int initialCount;
    private SpriteCollection gameScreen;
    private long initiationTime;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the  number to count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.running = true;
        this.numOfSec = numOfSeconds * 1000;
        this.countFrom = countFrom;
        this.initialCount = countFrom;
        this.gameScreen = gameScreen;
        this.initiationTime = System.currentTimeMillis();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.countFrom == 0) {
            this.running = false;
        }
        d.setColor(Color.black);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        this.gameScreen.drawAllOn(d);
        d.drawText(385, 450, Integer.toString(this.countFrom), 65);
        if (System.currentTimeMillis() - this.initiationTime
                > this.numOfSec / this.initialCount) {
            this.initiationTime = System.currentTimeMillis();
            this.countFrom--;
        }
    }
@Override
    public boolean shouldStop() {
        return !this.running;
    }
}