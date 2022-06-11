import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The type Animation runner.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * Instantiates a new Animation runner.
     */
    public AnimationRunner() {
        this.framesPerSecond = 60;
        this.gui = new GUI("Arkanoid", 800, 600);
        this.sleeper = new Sleeper();
    }

    /**
     * Run the animation.
     *
     * @param animation the animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * Gets gui.
     * return the gui.
     * @return the gui
     */
    public GUI getGui() {
        return this.gui;
    }
}