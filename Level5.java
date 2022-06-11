import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 5.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class Level5 implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> ballsVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Level 5.
     */
    public Level5() {
        this.numberOfBalls = 5;
        this.ballsVelocities = new ArrayList<>();
        ballsVelocities.add(Velocity.fromAngleAndSpeed(30, 4));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(40, 4));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(50, 4));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(60, 4));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(80, 4));
        this.paddleSpeed = 10;
        this.paddleWidth = 100;
        this.levelName = "eurolig";
        this.background = new Filed();
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 46;
        int blockW = 45;
        for (int i = 0; i < 16; i++) {
            Rectangle block = new Rectangle(
                    new Point(33 + (i * (blockW)) + i, 300), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 6; i++) {
            Rectangle block = new Rectangle(
                    new Point(255, 72 + 20 * i + i), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 6; i++) {
            Rectangle block = new Rectangle(
                    new Point(501, 72 + 20 * i + i), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 6; i++) {
            Rectangle block = new Rectangle(
                    new Point(301, 72 + 20 * i + i), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 6; i++) {
            Rectangle block = new Rectangle(
                    new Point(454, 72 + 20 * i + i), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                Rectangle block = new Rectangle(
                        new Point(352 + 50 * j + j, 135 + 20 * i + i), blockW, 20);
                this.blocks.add(new Block(block, Color.white));
            }
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


