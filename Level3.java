import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 3.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class Level3 implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> ballsVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Level 3.
     */
    public Level3() {
        this.numberOfBalls = 2;
        this.ballsVelocities = new ArrayList<>();
        ballsVelocities.add(Velocity.fromAngleAndSpeed(80, 8));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(60, 8));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(40, 8));
        this.paddleSpeed = 5;
        this.paddleWidth = 60;
        this.levelName = "sunset";
        this.background = new Sea();
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 40;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10 - i; j++) {
                Point point = new Point(730 - 41 * j, 100 + i * 20 + i);
                Color color;
                switch (i + 1) {
                    case (1):
                        color = Color.GRAY;
                        break;
                    case (2):
                        color = Color.RED;
                        break;
                    case (3):
                        color = Color.YELLOW;
                        break;
                    case (4):
                        color = Color.BLUE;
                        break;
                    case (5):
                        color = Color.WHITE;
                        break;
                    default:
                        color = Color.BLACK;
                        break;
                }
                blocks.add(new Block(new Rectangle(point, 40, 20), color));
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



