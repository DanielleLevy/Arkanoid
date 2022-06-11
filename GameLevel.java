import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.List;

/**
 * The type GameLevel.
 *
 * @author Daniel Levy ID:208150433
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter countBlockRemain;
    private Counter countBallRemain;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    private Paddle p;

    /**
     * Instantiates a new Game level.
     *
     * @param levelInformation the level information
     * @param keyboard         the keyboard sensor
     * @param runner           the runner animation
     * @param s                the score
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboard, AnimationRunner runner, Counter s) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.countBlockRemain = new Counter(0);
        this.countBallRemain = new Counter(0);
        this.score = s;
        this.runner = runner;
        this.gui = this.runner.getGui();
        this.running = true;
        this.keyboard = keyboard;
        this.levelInformation = levelInformation;
    }

    /**
     * Backround level.
     * add to the spirit array the background.
     */
    public void backroundLevel() {
        if (this.levelInformation.getBackground() != null) {
            this.sprites.addSprite(this.levelInformation.getBackground());
        }
    }

    /**
     * create Balls.
     * create the balls and add them to the game.
     */
    private void createsBalls() {
        List<Velocity> velocities = this.levelInformation.initialBallVelocities();
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball((800 / 2) + i * 10, 540, 5, Color.white);
            ball.setVelocity(velocities.get(i));
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
        }
    }
    /**
     * create blocks.
     * create the blocks and add them to the game.
     */
    private void createsBlocks() {
        this.countBlockRemain = new Counter(this.levelInformation.numberOfBlocksToRemove());
        BlockRemover blockRe = new BlockRemover(this, this.countBlockRemain);
        ScoreTrackingListener scoreTrackLi = new ScoreTrackingListener(this.score);
        List<Block> numOfBlocks = this.levelInformation.blocks();
        for (Block block : numOfBlocks) {
            block.addHitListener(blockRe);
            block.addHitListener(scoreTrackLi);
            block.addToGame(this);
        }
    }

    /**
     * create paddle.
     * create the paddle and add it to the game.
     */
    private void createsPaddle() {
        Rectangle paddle = new Rectangle(
                new Point((800 - this.levelInformation.paddleWidth()) / 2, 550),
                this.levelInformation.paddleWidth(), 20
        );
        Paddle pGame = new Paddle(paddle, Color.cyan, 800, gui.getKeyboardSensor());
        pGame.addToGame(this);
        this.p = pGame;
    }

    /**
     * The method adds a Collidable to the game environment.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * The method adds a Sprite to the game environment.
     *
     * @param s the Sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * create indicators.
     * create the indicators and add them to the game.
     */
    private void createsIndicators() {
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        addSprite(scoreIndicator);
        LevelNumber level = new LevelNumber(this.levelInformation.levelName());
        level.addToGame(this);
    }
    /**
     * create limit block.
     * create the limit block and add them to the game.
     */
    private void createsLimitingBlocks() {
        BlockRemover blockRemover = new BlockRemover(this, this.countBlockRemain);
        BallRemover ballRemover = new BallRemover(this, this.countBallRemain);
        Point upLeftScreen = new Point(0, 40);
        Point downScreen = new Point(0, 600);
        Point leftScreen = new Point(770, 51);
        Point rightScreen = new Point(0, 51);
        Block upScreenB = new Block(new Rectangle(upLeftScreen, 800, 30), Color.white);
        Block downScreenB = new Block(new Rectangle(downScreen, 800, 50), Color.white);
        Block leftScreenB = new Block(new Rectangle(leftScreen, 30, 569), Color.white);
        Block rightScreenB = new Block(new Rectangle(rightScreen, 30, 569), Color.white);
        rightScreenB.addToGame(this);
        leftScreenB.addToGame(this);
        upScreenB.addToGame(this);
        downScreenB.addToGame(this);
        downScreenB.addHitListener(ballRemover);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle).
     * add the Blocks and Ball (and Paddle) to the game.
     */
    public void initialize() {
        backroundLevel();
        createsIndicators();
        createsLimitingBlocks();
        createsBlocks();
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        createsBalls();
        if (this.p != null) {
            this.removeCollidable(p);
            this.removeSprite(p);
        }
        createsPaddle();
        this.countBallRemain.increase(this.levelInformation.numberOfBalls());
        this.runner.run(new CountdownAnimation(3, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
        if (this.countBlockRemain.getValue() != 0) {
            if (end()) {
                this.running = false;
            } else {
                run();
            }
        }
        if (this.countBlockRemain.getValue() == 0) {
            this.running = false;
        }
    }

    /**
     * Remove collidable from the game.
     *
     * @param c the collidable to remove
     */
    void removeCollidable(Collidable c) {
        this.environment.removeCollidabe(c);
    }

    /**
     * Remove sprite from the game.
     *
     * @param s the sprite to remove
     */
    void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            d = this.gui.getDrawSurface();
            this.sprites.drawAllOn(d);
            this.gui.show(d);
            this.sprites.notifyAllTimePassed();

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
            if (this.countBlockRemain.getValue() == 0) {
                this.running = false;
                break;
            }
            if (this.countBallRemain.getValue() == 0) {
                this.running = false;
                break;
            }
            if (this.keyboard.isPressed("p")) {
                this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                        new PauseScreen()));
            }
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * End boolean.
     *
     * @return the boolean
     */
    public boolean end() {
        return this.countBallRemain.getValue() == 0;
    }
}

