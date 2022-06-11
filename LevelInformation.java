import java.util.List;

/**
 * The interface Level information.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public interface LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the int
     */
    int numberOfBalls();

    /**
     * Initial ball velocities list.
     *
     * @return the list of ball velocity
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed int.
     *
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * Paddle width int.
     *
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * Level name string.
     * the level name will be displayed at the top of the screen.
     * @return the string
     */
    String levelName();

    /**
     * Gets background.
     * Returns a sprite with the background of the level
     * @return the background
     */
    Sprite getBackground();

    /**
     * Blocks list.
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     * @return the list of block
     */
    List<Block> blocks();

    /**
     * Number of blocks to remove int.
     *
     * @return the  Number of blocks that should be removed
     */
    int numberOfBlocksToRemove();
}