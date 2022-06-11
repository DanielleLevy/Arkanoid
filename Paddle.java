import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type Paddle.
 *
 * @author Daniel Levy ID:208150433
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle shape;
    private Color color;
    private int widthS;

    /**
     * constructor.
     * Instantiates a new Paddle.
     *
     * @param rectangle the shape of the paddle
     * @param color     the color of the paddle
     * @param wScreen   the width screen
     * @param k         the keyboard Sensor
     */
    public Paddle(Rectangle rectangle, Color color, int wScreen, biuoop.KeyboardSensor k) {
        this.color = color;
        this.shape = rectangle;
        this.keyboard = k;
        this.widthS = wScreen;
    }


    /**
     * The method moves the paddle to the left.
     * The method ensures that the paddle does not go beyond the screen.
     */
    public void moveLeft() {
        if (this.shape.getUpperLeft().getX() > 30) {
            Point point = new Point(this.shape.getUpperLeft().getX() - 5, this.shape.getUpperLeft().getY());
            this.shape = new Rectangle(point, this.shape.getWidth(), this.shape.getHeight());
        }
    }

    /**
     * The method moves the paddle to the right.
     * The method ensures that the paddle does not go beyond the screen.
     */
    public void moveRight() {
        if (this.shape.getUpperLeft().getX() + this.shape.getWidth() < 770) {
            Point point = new Point(this.shape.getUpperLeft().getX() + 5, this.shape.getUpperLeft().getY());
            this.shape = new Rectangle(point, this.shape.getWidth(), this.shape.getHeight());
        }
    }

    /**
     * draw the paddle to the screen.
     *
     * @param d the surface
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.cyan);
        d.fillRectangle((int) this.shape.getUpperLeft().getX(), (int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());

    }

    /**
     * notify the paddle that time has passed.
     * check what is pressed and move.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * The method returns the collision shape of the object.
     *
     * @return the collision rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter          the ball who hit
     * @return the new velocity after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double paddleP = (this.shape.getWidth() / 5 + this.shape.getUpperLeft().getX());
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                + Math.pow(currentVelocity.getDy(), 2));
        if (collisionPoint.getX() <= paddleP) {
            return Velocity.fromAngleAndSpeed(300, speed);
        }
        if (collisionPoint.getX() <= 2 * paddleP) {
            return Velocity.fromAngleAndSpeed(330, speed);
        }
        if (collisionPoint.getX() <= 3 * paddleP) {
            return new Velocity(currentVelocity.getDx(),
                    -currentVelocity.getDy());
        }
        if (collisionPoint.getX() <= 4 * paddleP) {
            return Velocity.fromAngleAndSpeed(30, speed);
        }
        if (collisionPoint.getX() <= 5 * paddleP) {
            return Velocity.fromAngleAndSpeed(60, speed);
        }
        return currentVelocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}