import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 4.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class Level4 implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> ballsVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Level 4.
     */
    public Level4() {
        this.numberOfBalls = 3;
        this.ballsVelocities = new ArrayList<>();
        ballsVelocities.add(Velocity.fromAngleAndSpeed(80, 8));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(60, 8));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(40, 8));
        this.paddleSpeed = 10;
        this.paddleWidth = 80;
        this.levelName = "sunshine";
        this.background = new Garden();
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 105;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                Point point = new Point(30 + (49.5 * j), 100 + (20 * i));
                Rectangle rectangle = new Rectangle(point, 48.5, 19);
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
                        color = Color.GREEN;
                        break;
                    case (5):
                        color = Color.WHITE;
                        break;
                    case (6):
                        color = Color.PINK;
                        break;
                    case (7):
                        color = Color.CYAN;
                        break;
                    default:
                        color = Color.BLACK;
                        break;
                }
                this.blocks.add(new Block(rectangle, color));
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



