import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 6.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class Level6 implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> ballsVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Level 6.
     */
    public Level6() {
        this.numberOfBalls = 3;
        this.ballsVelocities = new ArrayList<>();
        ballsVelocities.add(Velocity.fromAngleAndSpeed(80, 8));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(60, 8));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(40, 8));
        this.paddleSpeed = 20;
        this.paddleWidth = 60;
        this.levelName = "all you need is love";
        this.background = new Heart();
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 90;
        int blockW = 20;
        for (int i = 0; i < 3; i++) {
            Rectangle block = new Rectangle(
                    new Point(150 + 20 * i + i, 150), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 3; i++) {
            Rectangle block = new Rectangle(
                    new Point(300 + 20 * i + i, 150), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 5; i++) {
            Rectangle block = new Rectangle(
                    new Point(129 + 20 * i + i, 172), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 5; i++) {
            Rectangle block = new Rectangle(
                    new Point(279 + 20 * i + i, 172), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 14; i++) {
                Rectangle block = new Rectangle(
                        new Point(109 + 20 * i + i, 193 + 21 * j), blockW, 20);
                this.blocks.add(new Block(block, Color.white));
            }
        }
        for (int i = 0; i < 12; i++) {
            Rectangle block = new Rectangle(
                    new Point(129 + 20 * i + i, 235), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 10; i++) {
            Rectangle block = new Rectangle(
                    new Point(149 + 20 * i + i, 256), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 8; i++) {
            Rectangle block = new Rectangle(
                    new Point(169 + 20 * i + i, 277), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 6; i++) {
            Rectangle block = new Rectangle(
                    new Point(189 + 20 * i + i, 298), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 4; i++) {
            Rectangle block = new Rectangle(
                    new Point(209 + 20 * i + i, 319), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        for (int i = 0; i < 2; i++) {
            Rectangle block = new Rectangle(
                    new Point(229 + 20 * i + i, 340), blockW, 20);
            this.blocks.add(new Block(block, Color.white));
        }
        Rectangle block = new Rectangle(
                new Point(240, 361), blockW, 20);
        this.blocks.add(new Block(block, Color.white));

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



