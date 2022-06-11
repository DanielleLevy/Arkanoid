import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The type Game flow.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private boolean win;
    private Counter remainingBlocks;
    private Counter remainingBalls;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the animation runner
     * @param ks the keyboard sensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        score = new Counter(0);
        win = true;
    }

    /**
     * Run levels.
     * run the levels in order.
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            this.remainingBlocks = new Counter(levelInfo.numberOfBlocksToRemove());
            this.remainingBalls = new Counter(0);
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.score);
            level.initialize();
            level.run();
            if (level.end()) {
                this.win = false;
            } else {
                this.score.increase(100);
            }
            this.animationRunner.run(
                    new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                            new EndScreen(win, score)
                    ));
            if (!win) {
                this.animationRunner.getGui().close();
            }
        }
        this.animationRunner.getGui().close();
    }
}

