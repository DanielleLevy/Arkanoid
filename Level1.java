import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 1.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class Level1 implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> ballsVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Level 1.
     */
    public Level1() {
        this.numberOfBalls = 1;
        this.ballsVelocities = new ArrayList<>();
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(0, 3));
        this.paddleSpeed = 5;
        this.paddleWidth = 50;
        this.levelName = "Direct Hit";
        this.background = new TargetBorad(100, 30);
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 1;
        Point centerBlockToHit = new Point(405 - 25 / 2, 205 - 25 / 2);
        Rectangle block = new Rectangle(centerBlockToHit, 15, 15);
        Block blockToHit = new Block(block, Color.cyan);
        this.blocks.add(blockToHit);

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
