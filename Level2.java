import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 2.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class Level2 implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> ballsVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Level 2.
     */
    public Level2() {
        this.numberOfBalls = 9;
        this.ballsVelocities = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls; i++) {
            this.ballsVelocities.add(Velocity.fromAngleAndSpeed(90 + (i * 18), 5));
        }
        this.paddleSpeed = 2;
        this.paddleWidth = 600;
        this.levelName = "star wars";
        this.background = new Universe();
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 14;
        int blockW = 750 / this.numberOfBlocksToRemove;
        for (int i = 0; i < this.numberOfBlocksToRemove; i++) {
            Rectangle block = new Rectangle(
                    new Point(25 + (i * (blockW)) + i, 300), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }

    }

    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.ballsVelocities;

    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public Sprite getBackground() {

        return this.background;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}


