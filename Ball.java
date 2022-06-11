import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Ball.
 *
 * @author Daniel Levy ID:208150433
 */
public class Ball implements Sprite, HitNotifier {
    private int r;
    private Point center;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners;


    /**
     * Instantiates a new Ball.
     *
     * @param center the center point
     * @param r      the radius
     * @param color  the color of the ball
     */
// constructor
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * Instantiates a new Ball.
     *
     * @param x     the x of the canter point
     * @param y     the y of the canter point
     * @param r     the radius
     * @param color the color of the ball
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point((int) x, (int) y);
        this.r = r;
        this.color = color;
    }

    /**
     * Gets x.
     *
     * @return the x of the center point.
     */
// accessors
    public double getX() {
        return this.center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y of the center point.
     */
    public double getY() {
        return this.center.getY();
    }

    /**
     * Gets size.
     *
     * @return the radius of the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Gets center.
     *
     * @return the center point of the ball.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * Sets Game Environment.
     * The method accepts a Game Environment and determines the Game Environment od the ball.
     *
     * @param gameEnvironment1 -the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment1) {
        this.gameEnvironment = gameEnvironment1;
    }

    /**
     * Gets color.
     *
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * The method calculates the collision trajectory of the ball.
     *
     * @return Collision trajectory of the ball
     */
    public Line trajectory() {
        Point endLine = this.getVelocity().applyToPoint(this.getCenter());
        return new Line(this.getCenter(), endLine);
    }


    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface the surface of the ball.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.getX(), (int) this.getY(), this.r);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * The method gets speed and determines the speed to the speed of the ball.
     *
     * @param v the velocity of the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets velocity.
     * The method accepts delta X-Y values and determines the speed of the ball.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        Velocity v = new Velocity(dx, dy);
        this.velocity = v;
    }

    /**
     * Sets r.
     *
     * @param radius the radius
     */
    public void setR(int radius) {
        this.r = radius;
    }

    /**
     * Sets center.
     *
     * @param x the x
     * @param y the y
     */
    public void setCenter(double x, double y) {
        this.center.setX(x);
        this.center.setY(y);
    }

    /**
     * Gets velocity.
     *
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Add to game.
     * The method adds the ball to the game
     *
     * @param g - the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Move one step.
     * The method causes the ball to move on the surface.
     * The movement of the ball is done according to its speed.
     * The method makes sure that the ball does not go out of bounds.
     * The method detects the ball hitting the blocks
     */
    public void moveOneStep() {


        CollisionInfo cInfo = gameEnvironment.getClosestCollision(this.trajectory());
        if (cInfo != null) {
            this.setCenter(cInfo.collisionPoint().getX() - this.velocity.getDx(),
                    cInfo.collisionPoint().getY() - this.velocity.getDy());
            this.setVelocity(cInfo.collisionObject().hit(this, cInfo.collisionPoint(), this.getVelocity()));
        }
        this.center = this.velocity.applyToPoint(this.center);
    }

    /**
     * Remove the ball from the game.
     *
     * @param g the game
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * Max radius int.
     * The method gets an array of balls.
     * The method returns the largest radius in the array.
     *
     * @param balls the array of balls
     * @return the maximum radius.
     */
    public static int maxRadius(Ball[] balls) {
        int maxBall = balls[0].getSize();
        for (int i = 1; i < balls.length; i++) {
            if (balls[i].getSize() > maxBall) {
                maxBall = balls[i].getSize();
            }
        }
        return maxBall;
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
